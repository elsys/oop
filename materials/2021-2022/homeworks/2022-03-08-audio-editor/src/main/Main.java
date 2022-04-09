package main;

import analysis.Analysis;
import analysis.Anomaly;
import analysis.Average;
import analysis.Max;
import transformer.Denoise;
import transformer.Mute;
import transformer.Normalize;
import transformer.Transformer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        float[] values = {-5, 2, 3, -4, 10, 12};

        Analysis[] test1 = {
                new Average(),
                new Max(),
                new Anomaly(3)
        };

        for(Analysis a : test1) a.process(values);
        for(Analysis a : test1) System.out.println(a.toString());

        Transformer[] test2 = {
                new Mute(),
                new Normalize(),
                new Denoise(3, 2)
        };

        for(Transformer t : test2) t.process(values);
        for(Transformer t : test2) {
            System.out.println(t.toString());
            System.out.println(Arrays.toString(t.getOutput()));
        }
    }
}
