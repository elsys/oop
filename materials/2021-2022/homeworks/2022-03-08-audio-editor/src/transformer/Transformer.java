package transformer;

import main.Processable;

import java.util.ArrayList;
import java.util.List;

public abstract class Transformer implements Processable {
    protected String type;
    protected float[] output;

    public Transformer(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public float[] getOutput() {
        return output;
    }

    public String toString() {
        return type;
    }

    protected List<Float> arrayToList(float[] array) {
        List<Float> result = new ArrayList<>(array.length);

        for(float v : array) result.add(v);

        return result;
    }
}
