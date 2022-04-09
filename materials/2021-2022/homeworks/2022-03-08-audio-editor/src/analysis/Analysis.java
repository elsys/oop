package analysis;

import main.Processable;

import java.util.ArrayList;
import java.util.List;

public abstract class Analysis implements Processable {
    protected String type;
    protected float output;

    public Analysis(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public float getOutput() {
        return output;
    }

    public String toString() {
        return type + " = " + output;
    }

    protected List<Float> arrayToList(float[] array) {
        List<Float> result = new ArrayList<>(array.length);

        for(float v : array) result.add(v);

        return result;
    }
}
