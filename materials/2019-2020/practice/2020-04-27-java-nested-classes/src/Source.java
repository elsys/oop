public interface Source {
    abstract class Event {
        public String type;
        public Object payload;
    }

    interface EventHandler {
        void handle(Event e);
    }
}
