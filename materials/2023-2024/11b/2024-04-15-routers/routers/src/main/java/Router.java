import java.util.*;

public class Router implements Runnable {
    private List<Router> other = new LinkedList<>();
    private List<Object> hosts = new LinkedList<>();

    private Queue<Object> packets = new LinkedList<>();
    private Queue<Object> waitingPackets = new LinkedList<>();

    private Map<String, Integer> arpTable = new TreeMap<>();

//    synchronized public List<Router> getOther() {
//        return other;
//    }

    @Override
    public void run() {
        try {
            while(true) {
                while(!packets.isEmpty()) {
                    Object packet = packets.remove();
                    processPacket(packet);
                    Thread.sleep(500);
                }

                synchronized (this) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Router shutting down");
        }
    }

    private void processPacket(Object packet) {
        String packetType = "data";

        switch (packetType) {
            case "data":
                processDataPacket(packet);
                break;
            case "query":
                processQueryPacket(packet);
                break;
        }
    }

    private void processQueryPacket(Object packet) {
        String destination = "H3";
        String srcRouter = "R1";

        Object host = findHost(destination);
        if(host != null) {
            Router r1; // = ???
            r1.receivePacket("type=found, destination=H3");
            return;
        }
    }

    private Object findHost(String destination) {
        for(Object host : hosts) {
            String hostName = "H3";
            if(hostName.equals(destination)) {
                return host;
            }
        }

        return null;
    }

    private void processDataPacket(Object packet) {
        String destination = "H3";

        for(Object host : hosts) {
            String hostName = "H3";
            if(hostName.equals(destination)) {
                System.out.println("host.receivePacket(packet);");
                return;
            }
        }

        if(arpTable.containsKey(destination)) {
            Integer neighborIndex = arpTable.get(destination);
            other.get(neighborIndex).receivePacket(packet);
            return;
        }

        for(Router neighbor : other) {
            neighbor.receivePacket("type: query, destination: H3");
        }

        waitingPackets.add(packet);
    }

    private void receivePacket(Object packet) {

    }
}
