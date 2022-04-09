package transformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Denoise extends Transformer {
    private int subSize;
    private int targetDiff;

    public Denoise(int subSize, int targetDiff) {
        super("Denoise");

        this.subSize = subSize;
        this.targetDiff = targetDiff;
    }

    @Override
    public String toString() {
        return type + " S = " + subSize + " M = " + targetDiff;
    }

    @Override
    public void process(float[] audio) {
        output = new float[audio.length];

        List<Float> valuesList = arrayToList(audio);

        // Iterate the whole array
        for(int i = 0; i <= audio.length - subSize; i++) {
            // Slice a sublist of size S
            List<Float> subArray = valuesList.subList(i, i + subSize);

            processSubList(valuesList, subArray, i);
        }

        for(int i = 0; i < audio.length; i++)
            output[i] = valuesList.get(i);
    }

    private void processSubList(List<Float> valuesList, List<Float> subArray, int i) {
        for(int j = 0; j < subArray.size(); j++) {
            float currItem = subArray.get(j);

            // Create a new list with all items except [i]
            List<Float> subArrayRemaining = new ArrayList<>(subArray);
            subArrayRemaining.remove(j);

            float median = findMedian(subArrayRemaining);
            // Look for items M times larger than the median
            if(Math.abs(currItem) >= targetDiff * Math.abs(median)) {
                float max = Collections.max(subArrayRemaining);
                valuesList.set(i + j, max);
            }
        }
    }

    private float findMedian(List<Float> items) {
        List<Float> sorted = new ArrayList<>(items);
        Collections.sort(sorted);
        int mid = (int) Math.floor(sorted.size() / 2);

        // Odd number of items => return the middle
        if(sorted.size() % 2 == 1) {
            return sorted.get(mid);
        }

        // Even number of items => return the average of the middle two
        return (sorted.get(mid - 1) + sorted.get(mid)) / 2;
    }
}