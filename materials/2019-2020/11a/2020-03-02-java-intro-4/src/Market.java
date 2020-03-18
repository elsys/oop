import java.util.List;

public class Market {
    void sell(List<ISellable> itemsToSell) {
        for(ISellable item : itemsToSell) {
            item.sell();
        }
    }
}
