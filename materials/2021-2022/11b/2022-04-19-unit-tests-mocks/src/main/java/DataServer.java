import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataServer {
    private final int maxCount;
    private Random rand;

    private String[] names = {
      "Fortnite",
      "PUBG",
      "DnD",
      "Amogus"
    };

    public DataServer(int maxCount, Random rand) {
        this.maxCount = maxCount;
        this.rand = rand;
    }

    public List<Package> generatePackages() {
        System.out.println("GENERATE");
        List<Package> generated = new LinkedList<>();

        int count = Math.abs(rand.nextInt() % maxCount);

        for(int i = 0; i < count; i++) {
            String sender = names[Math.abs(rand.nextInt() % names.length)];
            long data = rand.nextLong();

            generated.add(new Package(sender, data));
            //Package newPack1 = new Package(sender, data);
            //generated.add(newPack1);
        }

        return generated;
    }
}
