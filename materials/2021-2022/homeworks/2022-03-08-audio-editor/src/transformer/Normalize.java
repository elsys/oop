package transformer;

import java.util.Collections;
import java.util.List;

public class Normalize extends Transformer {
    public Normalize() {
        super("Normalize");
    }

    private float normalizeValue(float value, float max, float min, float newMin, float newMax) {
        return newMin + ((value - min) * (newMax - newMin))/(max - min);
    }

    @Override
    public void process(float[] audio) {
        output = new float[audio.length];

        List<Float> valuesList = arrayToList(audio);
        float maxValue = Collections.max(valuesList);
        float minValue = Collections.min(valuesList);

        for(int i = 0; i < audio.length; i++) {
            output[i] = normalizeValue(audio[i], maxValue, minValue, -1, 1);
        }
    }
}