package qtlog.FilesystemController;

import qtlog.DataModel.IFileObserver;
import qtlog.shared.FileDTO;
import qtlog.util.ConfigManager;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;

public class FileMonitor implements IFileMonitor, IFileObservable, Runnable{
    IFileObserver observer;
    Path filepath;
    WatchService watchservice;
    FileDTO newestFile;
    private boolean trace;
    private Map<WatchKey, Path> keys;

    public FileMonitor(){
        this.trace = false;
        this.filepath = Paths.get(ConfigManager.readLogPath());
        this.newestFile = new FileDTO("dummy", "dummypath");
    }

    @Override
    public void registerObs(IFileObserver observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver() {
        this.observer.updateFileObserver();
    }

    @Override
    public FileDTO getFileInformation() {
        return newestFile;
    }
    
    @Override
    public void run() {
        try {
            this.WatchDir(this.filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.processEvents();
    }

    /**
     * Register the given directory, and all its sub-directories, with the
     * WatchService.
     */
    private void registerAll(final Path start) throws IOException {
        // register directory and sub-directories
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException
            {
                registerKey(dir);
                System.out.format("Registering dir: %s ...\n", dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Register the given directory with the WatchService
     */
    private void registerKey(Path dir) throws IOException  {
        WatchKey key = dir.register(watchservice, StandardWatchEventKinds.ENTRY_MODIFY);
        if (trace) {
            Path prev = keys.get(key);
            if (prev == null) {
                System.out.format("register: %s\n", dir);
            } else {
                if (!dir.equals(prev)) {
                    System.out.format("update: %s -> %s\n", prev, dir);
                }
            }
        }
        keys.put(key, dir);
    }

    /**
     * Creates a WatchService and registers the given directory
     */
    private void WatchDir(Path dir) throws IOException {
        this.watchservice = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<WatchKey,Path>();

        System.out.format("Scanning %s ...\n", dir);
        this.registerAll(dir);
        System.out.println("Done.");

        // enable trace after initial registration
        this.trace = true;
    }

    /**
     * Process all events for keys queued to the watcher
     */
    void processEvents() {
        WatchEvent<Path> lastEvent = null;
        while(true) {

            // wait for key to be signalled
            WatchKey key;
            try {
                key = watchservice.take();
            } catch (InterruptedException x) {
                return;
            }

            Path dir = keys.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!!");
                continue;
            }

            for (WatchEvent<?> event: key.pollEvents()) {
                
                // Context for directory entry event is the file name of entry
                WatchEvent<Path> ev = cast(event);
                
                Path name = ev.context();
                Path child = dir.resolve(name);

                if(lastEvent != StandardWatchEventKinds.ENTRY_MODIFY){
                    this.newestFile.setFilename(name.toString());
                    this.newestFile.setFilepath(child.toString());
                    this.notifyObserver();
                    System.out.format("%s: %s Name: %s\n", event.kind().name(), child, name);
                }
                lastEvent = ev;
            }
            // reset key
            key.reset();
        }
    }

    @SuppressWarnings("unchecked")
    static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>)event;
    }
}
