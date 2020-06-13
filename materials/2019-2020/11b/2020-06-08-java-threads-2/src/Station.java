public class Station {
    public int storage = 0;
    Truck truck;

    public Station() {
    }

    public Station(Truck truck) {
        this.truck = truck;
    }

    public void unloadTrain(int load) {
        storage += load;
        System.out.println("Station storage is " + storage);

        // TODO: inform truck
        if(storage >= truck.capacity) {
            truck.load(storage);
        }
    }

    public int loadTrain() {
        return 10;
    }
}
