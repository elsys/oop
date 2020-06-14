public class Station {
    public int storage = 0;
    Truck truck;

    public Station() {}

    public Station(Truck truck) {
        this.truck = truck;
    }

    public void unloadTrain(int load) {
        storage += load;
        System.out.println("Station storage is " + storage);
        if(storage >= truck.capacity) {
            truck.load(truck.capacity);
//            synchronized (truck) {
//                truck.cargo = truck.capacity;
//                truck.notify();
//            }
            storage -= truck.capacity;
        }
    }

    public int loadTrain() {
        return 10;
    }
}
