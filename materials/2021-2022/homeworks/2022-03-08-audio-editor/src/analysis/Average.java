package analysis;

public class Average extends Analysis {
    public Average() {
        super("Average");
    }

    @Override
    public void process(float[] audio) {
        float sum = 0;
        for (float v : audio) {
            sum += v;
        }

        output = sum / audio.length;
    }
}
