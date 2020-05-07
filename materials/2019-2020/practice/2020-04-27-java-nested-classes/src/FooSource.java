import java.util.ArrayList;
import java.util.List;

public class FooSource implements Source {
    private List<EventHandler> handlers = new ArrayList<>();

    public void run() throws InterruptedException {
        for(int i=1; i < 11; i++) {
            Thread.sleep(500);
            FooEvent e = new FooEvent(10 * i );
            for(EventHandler eh : handlers) {
                eh.handle(e);
            }
        }
    }

    static class FooEvent extends Event {
        public final String type = "FooEvent";
        public Integer payload;

        FooEvent(int p) {
            payload = p;
        }
    }

    void subscribe(EventHandler handler) {
        handlers.add(handler);
    }
}
