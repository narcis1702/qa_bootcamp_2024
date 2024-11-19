package building;

public class Toilet extends Room {
    public Toilet(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
