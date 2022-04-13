package transformer;

import java.util.Arrays;

public class Mute extends Transformer {
    public Mute() {
        super("Mute");
    }

    @Override
    public void process(float[] audio) {
        output = new float[audio.length];
        Arrays.fill(output, 0);
    }
}
