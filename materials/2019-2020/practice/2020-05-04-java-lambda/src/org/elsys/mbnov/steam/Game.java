package org.elsys.mbnov.steam;

import java.util.List;

public class Game {
    public String id;
    public String title;
    public float price;
    public List<String> features;

    public Game(String id, String title, float price, List<String> features) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.features = features;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", features=" + features +
                '}';
    }
}
