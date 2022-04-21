import java.util.List;
import java.util.Random;

public class DataClient {
    private DataServer server;

    public DataClient(DataServer server) {
        this.server = server;
    }

    public void consumePackages() {
        System.out.println("CONSUMING");
        List<Package> generated = server.generatePackages();

        for(Package pack : generated) {
            System.out.println(pack.sender + " " + pack.data);
        }
    }

    public static void main(String[] args) {
        DataServer ds = new DataServer(10, new Random());
        DataClient dc = new DataClient(ds);

        dc.consumePackages();
        dc.consumePackages();
        dc.consumePackages();
    }
}
