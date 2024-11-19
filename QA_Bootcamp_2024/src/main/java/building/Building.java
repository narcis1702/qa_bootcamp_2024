package building;
import java.util.ArrayList;
import java.util.List;

public class Building {
    private String name;
    private List<Floor> floors;

    public Building(String name) {
        this.name = name;
        this.floors = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Building " + name + " has " + floors.size() + " floors\n");
        for (Floor floor : floors) {
            sb.append(floor + "\n");
        }
        return sb.toString();
    }
}
