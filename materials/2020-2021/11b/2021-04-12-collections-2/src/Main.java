import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("Kon", "Kopitni", "Bozainici"));
        animals.add(new Animal("Riba", "Morski", "Vodni"));

        //Map<Animal, Animal> animals2 = new HashMap();
        Map<Integer, Animal> animals2 = new TreeMap();

        Animal myHorse = new Animal("Kon", "Kopitni", "Bozainici");
        //animals2.put((new StringBuilder(myHorse.species + myHorse.family + myHorse.order)).toString(), myHorse);
        animals2.put(myHorse.hashCode(), myHorse);

        Animal myFish = new Animal("Riba", "Morski", "Vodni");
        //animals2.put((new StringBuilder(myFish.species + myFish.family + myFish.order)).toString(), myHorse);
        animals2.put(myFish.hashCode(), myFish);

        for(Map.Entry<Integer, Animal> a : animals2.entrySet()) {
            System.out.println(a.getValue());
        }*/


        Set<Animal> animals3 = new HashSet<>();
        animals3.add(new Animal("Kon", "Kopitni", "Bozainici"));
        animals3.add(new Animal("Kon", "Kopitni", "Bozainici"));
        animals3.add(new Animal("Kon", "Kopitni", "Bozainici"));
        animals3.add(new Animal("Riba", "Morski", "Vodni"));

        for(Animal a : animals3) {
            System.out.println(a.hashCode());
            System.out.println(a);
        }
    }

    class DatabaseErrorException extends Exception {
        public String query;
        public int processId;

        public DatabaseErrorException(String message, String query, int processId) {
            super(message);
            this.query = query;
            this.processId = processId;
        }
    }

    private void accessDatabase() {
        try {
            throw new DatabaseErrorException("my message", "SELECT * from Users", 17);
        } catch(DatabaseErrorException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.query);
        }
    }
}

