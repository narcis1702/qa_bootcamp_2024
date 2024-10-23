package building;

import java.util.List;

public class ConferenceRoom extends Room {
    private int seats;
    private List<Appliance> appliances;

    public ConferenceRoom(String name, int seats, List<Appliance> appliances) {
        super(name);
        this.seats = seats;
        this.appliances = appliances;
    }

    @Override
    public String toString() {
        return name + ": " + seats + " seats, appliances: " + appliances;
    }
}
