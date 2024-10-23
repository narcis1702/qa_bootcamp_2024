package building;

import java.util.List;

public class Kitchen extends Room {
    private List<Appliance> appliances;

    public Kitchen(String name, List<Appliance> appliances) {
        super(name);
        this.appliances = appliances;
    }

    @Override
    public String toString() {
        return name + " with appliances: " + appliances;
    }
}
