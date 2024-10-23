package building;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Building building = new Building("X");

        Floor firstFloor = new Floor(1);
        firstFloor.addRoom(new OfficeSpace("Office Space 1", 20));
        firstFloor.addRoom(new Toilet("Toilet 1"));
        firstFloor.addRoom(new Toilet("Toilet 2"));
        firstFloor.addRoom(new Kitchen("Kitchen", Arrays.asList(Appliance.COFFEE_MACHINE, Appliance.WATER_DISPENSER, Appliance.FRIDGE)));
        firstFloor.addRoom(new ConferenceRoom("Conference Room 1", 10, Arrays.asList(Appliance.TV)));
        firstFloor.addRoom(new ConferenceRoom("Conference Room 2", 10, Arrays.asList(Appliance.TV)));
        firstFloor.addRoom(new ConferenceRoom("Conference Room 3", 10, Arrays.asList(Appliance.TV)));
        building.addFloor(firstFloor);

        Floor secondFloor = new Floor(2);
        secondFloor.addRoom(new OfficeSpace("Office Space 1", 10));
        secondFloor.addRoom(new OfficeSpace("Office Space 2", 10));
        secondFloor.addRoom(new Toilet("Toilet 1"));
        secondFloor.addRoom(new Toilet("Toilet 2"));
        secondFloor.addRoom(new Kitchen("Kitchen", Arrays.asList(Appliance.COFFEE_MACHINE, Appliance.WATER_DISPENSER, Appliance.FRIDGE)));
        secondFloor.addRoom(new ConferenceRoom("Conference Room 1", 8, Arrays.asList(Appliance.TV)));
        secondFloor.addRoom(new ConferenceRoom("Conference Room 2", 8, Arrays.asList(Appliance.TV)));
        secondFloor.addRoom(new ConferenceRoom("Conference Room 3", 8, Arrays.asList(Appliance.TV)));
        secondFloor.addRoom(new ConferenceRoom("Conference Room 4", 8, Arrays.asList(Appliance.TV)));
        building.addFloor(secondFloor);

        Floor thirdFloor = new Floor(3);
        thirdFloor.addRoom(new Toilet("Toilet 1"));
        thirdFloor.addRoom(new Toilet("Toilet 2"));
        thirdFloor.addRoom(new ConferenceRoom("Conference Room 1", 30, Arrays.asList(Appliance.VIDEO_PROJECTOR, Appliance.TELEPRESENCE_EQUIPMENT)));
        thirdFloor.addRoom(new ConferenceRoom("Conference Room 2", 20, Arrays.asList(Appliance.TV, Appliance.TELEPRESENCE_EQUIPMENT)));
        thirdFloor.addRoom(new ConferenceRoom("Conference Room 3", 10, Arrays.asList(Appliance.TV, Appliance.TELEPRESENCE_EQUIPMENT)));
        thirdFloor.addRoom(new ConferenceRoom("Conference Room 4", 10, Arrays.asList(Appliance.TV, Appliance.TELEPRESENCE_EQUIPMENT)));
        thirdFloor.addRoom(new ConferenceRoom("Conference Room 5", 10, Arrays.asList(Appliance.TV, Appliance.TELEPRESENCE_EQUIPMENT)));
        thirdFloor.addRoom(new ConferenceRoom("Conference Room 6", 10, Arrays.asList(Appliance.TV, Appliance.TELEPRESENCE_EQUIPMENT)));
        building.addFloor(thirdFloor);

        System.out.println(building);
    }
}
