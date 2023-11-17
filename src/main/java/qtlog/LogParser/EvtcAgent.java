package qtlog.LogParser;

public class EvtcAgent {
    public EvtcAgent(long addr, int prof, int is_Elite, int toughness, int concentration, int healing, int hitbox_width, int condition, int hitbox_height, String name) {
        this.addr = addr;
        this.prof = prof;
        this.is_Elite = is_Elite;
        this.toughness = toughness;
        this.concentration = concentration;
        this.healing = healing;
        this.hitbox_width = hitbox_width;
        this.condition = condition;
        this.hitbox_height = hitbox_height;
        this.name = name;
    }

    private long addr;
    private int prof;
    private int is_Elite;
    private int toughness;
    private int concentration;
    private int healing;
    private int hitbox_width;
    private int condition;
    private int hitbox_height;
    private String name;
}
