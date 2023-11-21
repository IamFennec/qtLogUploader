package qtlog.FilesystemController;

import qtlog.DataModel.IFileObserver;
import qtlog.util.ConfigManager;

import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class FileMonitor implements IFileMonitor, IFileObservable, Runnable {
    IFileObserver observer;
    java.nio.file.Path filepath;
    WatchService watchservice;
    Path newestFile;
    private boolean trace;
    private Map<WatchKey, java.nio.file.Path> keys;

    public FileMonitor() {
        this.trace = false;
        this.filepath = Paths.get(ConfigManager.readLogPath());
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
    public Path getFileInformation() {
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
     * Register the given directory, and all its subdirectories, with the
     * WatchService.
     */
    private void registerAll(final java.nio.file.Path start) throws IOException {
        // register directory and subdirectories
        Files.walkFileTree(start, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(java.nio.file.Path dir, BasicFileAttributes attrs)
                    throws IOException {
                registerKey(dir);
                System.out.format("Registering dir: %s ...\n", dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Register the given directory with the WatchService
     */
    private void registerKey(java.nio.file.Path dir) throws IOException {
        WatchKey key = dir.register(watchservice, StandardWatchEventKinds.ENTRY_CREATE);
        if (trace) {
            java.nio.file.Path prev = keys.get(key);
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
    private void WatchDir(java.nio.file.Path dir) throws IOException {
        this.watchservice = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<>();

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
        WatchEvent<java.nio.file.Path> lastEvent = null;
        while (true) {

            // wait for key to be signalled
            WatchKey key;
            try {
                key = watchservice.take();
            } catch (InterruptedException x) {
                return;
            }

            java.nio.file.Path dir = keys.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!!");
                continue;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                // Context for directory entry event is the file name of entry
                WatchEvent<java.nio.file.Path> ev = cast(event);

                java.nio.file.Path child = dir.resolve(ev.context());
                if (isFileStable(child)) {
                    if (isEvtcFile(child)) {
                        this.newestFile = child;
                        this.notifyObserver();
                    }
                }
            }
            // reset key
            key.reset();
        }
    }

    @SuppressWarnings("unchecked")
    static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>) event;
    }

    private boolean isFileStable(Path filePath) {
        try (FileChannel channel = FileChannel.open(filePath, StandardOpenOption.WRITE);
                FileLock lock = channel.lock()) {

            // If the lock is acquired, the file is stable
            return true;
        } catch (IOException e) {
            // Unable to acquire lock, file is likely being written
            return false;
        }
    }

    private boolean isEvtcFile(Path filePath) {
        return filePath.getFileName().toString().endsWith("evtc");
    }
}
