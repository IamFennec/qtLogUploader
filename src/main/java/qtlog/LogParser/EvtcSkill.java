package qtlog.LogParser;

public class EvtcSkill {
    private final int id;
    private final String name;
    public EvtcSkill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
