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

    public long getAddr() {
        return addr;
    }

    public int getProf() {
        return prof;
    }

    public int getIs_Elite() {
        return is_Elite;
    }

    public int getToughness() {
        return toughness;
    }

    public int getConcentration() {
        return concentration;
    }

    public int getHealing() {
        return healing;
    }

    public int getHitbox_width() {
        return hitbox_width;
    }

    public int getCondition() {
        return condition;
    }

    public int getHitbox_height() {
        return hitbox_height;
    }

    public String getName() {
        return name;
    }
}
