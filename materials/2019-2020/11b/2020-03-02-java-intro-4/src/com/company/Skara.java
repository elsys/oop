package com.company;

import java.util.List;

public class Skara {
    void bake(List<IBakable> stuffToBake) {
        for (IBakable item : stuffToBake) {
            item.bake(this);
        }
    }
}
