package building;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Floor {
    private int floorNumber;
    private List<Room> rooms;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Floor " + floorNumber + ":\n");

        Map<String, Integer> roomCounts = new HashMap<>();
        for (Room room : rooms) {
            roomCounts.put(room.getClass().getSimpleName(), roomCounts.getOrDefault(room.getClass().getSimpleName(), 0) + 1);
        }

        for (String roomType : roomCounts.keySet()) {
            sb.append(roomCounts.get(roomType) + " " + roomType.toLowerCase() + (roomCounts.get(roomType) > 1 ? "s" : "") + "\n");
        }

        int roomCounter = 1;
        for (Room room : rooms) {
            sb.append(roomCounter++ + ". " + room + "\n");
        }

        return sb.toString();
    }
}
