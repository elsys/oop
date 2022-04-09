package analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Anomaly extends Analysis {
    private int subSize;

    public Anomaly(int subSize) {
        super("Anomaly");

        this.subSize = subSize;
    }

    @Override
    public void process(float[] audio) {
        int anomalyCounter = 0;

        List<Float> valuesList = arrayToList(audio);

        // Iterate the whole array
        for(int i = 0; i < audio.length - subSize; i++) {
            // Slice a sublist of size S
            List<Float> subArray = valuesList.subList(i, i + subSize);

            anomalyCounter += processSubList(subArray);
        }

        output = anomalyCounter / (float)audio.length;
    }

    private int processSubList(List<Float> subArray) {
        int anomalyCounter = 0;

        for(int i = 0; i < subArray.size(); i++) {
            float currItem = subArray.get(i);

            // Create a new list with all items except [i]
            List<Float> subArrayRemaining = new ArrayList<>(subArray);
            subArrayRemaining.remove(i);

            float median = findMedian(subArrayRemaining);
            // Look for items 2 times larger than the median
            if(Math.abs(currItem) >= 2 * Math.abs(median)) anomalyCounter++;
        }

        return anomalyCounter;
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
