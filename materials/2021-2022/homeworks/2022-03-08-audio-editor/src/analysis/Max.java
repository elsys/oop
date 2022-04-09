package analysis;

public class Max extends Analysis {
    public Max() {
        super("Max");
    }

    @Override
    public void process(float[] audio) {
        float max = audio[0];
        for (float v : audio) {
            if(max < v) max = v;
        }

        output = max;
    }
}
