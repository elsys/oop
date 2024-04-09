import java.util.List;

public class Worker extends GameEntity implements Runnable {
    private int speed;
    private ResourceType targetType;
    private List<Building> buildings;
    private List<GameEntity> sources;

    private GameEntity source = null;
    private Building depot = null;

    @Override
    public void run() {
        try {
            while(true) {
                findSource();
                if(source == null) {
                    Thread.sleep(200);
                    continue;
                }

                moveTo(source);

                synchronized (source) {
                    if (!source.isFree())
                        continue;
                    source.addWorked(this);
                }

                harvest(source);

                findDepot();
                if(depot == null){
                    Thread.sleep(200);
                    continue;
                }

                moveTo(depot);
                unload(depot);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void findDepot() {

    }

    private void harvest(GameEntity source) {

    }

    private void unload(Building depot) {

    }

    private void findSource() {
        for(GameEntity e : sources) {
            if(e.resourceType == targetType && e.isFree()) {
                source = e;
                break;
            }
        }
        source = null;
    }

    private void moveTo(GameEntity source) throws InterruptedException {
        while(x != source.x && y != source.y) {
            if(x != source.x)
                x += 1;
            else y += 1;

            Thread.sleep(1000);
        }
    }
}
