import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataServer {
    private String[] randNames = {
      "Ivan",
      "Petar",
      "Mario",
      "Stefan",
      "Go$o"
    };

    private int maxPackages = 0;
    private Random rand;

    public DataServer(int maxPackages, Random rand) {
        this.maxPackages = maxPackages;
        this.rand = rand;
    }

    public List<Package> generatePackages() {
        System.out.println("GENERATING");
        List<Package> generated = new LinkedList<>();

        int count = Math.abs(rand.nextInt() % maxPackages);

        for(int i =0; i < count; i++) {
            int index = Math.abs(rand.nextInt() % randNames.length);
//            System.out.println(index);
            String sender = randNames[index];
            long data = rand.nextLong();

            generated.add(new Package(sender, data));
        }

        return generated;
    }
}
