package building;

public abstract class Room {
    String name;

    public Room(String name) {
        this.name = name;
    }

    @Override
    public abstract String toString();
}
