import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ParallelList<T> extends LinkedList {
    @Override
    public void forEach(Consumer action) {
        ExecutorService ex = Executors.newFixedThreadPool(5);
        super.forEach((e) ->
            ex.submit(() -> action.accept(e))
        );
        ex.shutdown();
    }
}
