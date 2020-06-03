import org.elsys.mbenov.imageclient.ImageClient;
import org.elsys.mbenov.imageclient.ImageData;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    static long[] filter = new long[]{
            0, -1L, 0,
            -1L, 4L, -1L,
            0, -1L, 0
    };

    public static void main(String[] args) throws InterruptedException, ParseException, IOException {
        ImageClient cl = new ImageClient("http://localhost:3000/api/image");
        ImageData id = cl.requestImage();
        //System.out.println(id);
        // System.out.println(id.toJSONString());

//        processV1(id);
        processV2(id);

        cl.sendImage(id);
    }

    private static void processV2(ImageData id) {
        List<Long> newData = IntStream
                .range(0, (int)(id.width * id.height))
                .mapToObj((index) -> {
                    long pixelX = indexToX(index, id);
                    long pixelY = indexToY(index, id);

                    List<Long> newPixel = new ArrayList<>();

                    if(pixelX == 0 || pixelY == 0 || pixelX == id.width - 1 || pixelY == id.height -1) {
                        for(int channel = 0; channel < 4; channel++) {
                            newPixel.add((long)id.data.get(index * 4 + channel));
                        }
                    } else {
                        for (int channel = 0; channel < 4; channel++) {
                            long newValue = applyFilterV2(id, index, channel);
                            newPixel.add(newValue);
                        }
                    }

                    return newPixel;
                })
                .reduce(new ArrayList<Long>(), (acc, pixel) -> {
                    acc.addAll(pixel);
                    return acc;
                });

        id.data = newData;
    }

    private static void processV1(ImageData id) {
        List<Long> newData = new ArrayList<>();

        for(int index = 0; index < id.width * id.height; index++) {
            long pixelX = index % id.width;
            long pixelY = (long)Math.floor(index / id.width);

            if(pixelX == 0 || pixelY == 0 || pixelX == id.width - 1 || pixelY == id.height -1) {
                for(int channel = 0; channel < 4; channel++) {
                    newData.add((long)id.data.get(index * 4 + channel));
                }
                continue;
            }

            for(int channel = 0; channel < 4; channel++) {
                long newValue = applyFilterV1(id, pixelX, pixelY, channel);
                newData.add(newValue);
            }
        }

        // try {
        //     FileWriter fwi = new FileWriter("in.txt");
        //     fwi.write(id.data.toString());
        //     fwi.close();
        //
        id.data = newData;
        //
        //     FileWriter fwo = new FileWriter("out.txt");
        //     fwo.write(id.data.toString());
        //     fwo.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    private static long applyFilterV1(ImageData id, long pixelX, long pixelY, int channel) {
        long[] values = new long[3 * 3];

        for(int offsetY = -1; offsetY <= 1; offsetY++) {
            for(int offsetX = -1; offsetX <= 1; offsetX++) {
                int pixelIndex = (int)((pixelY + offsetY) * id.width + (pixelX + offsetX));
                int pixelValueIndex = pixelIndex * 4;
                int finalIndex = pixelValueIndex + channel;

                values[(offsetY+1) * 3 + (offsetX+1)] = (long)id.data.get(finalIndex);
            }
        }

        long filterResultDiff = LongStream
                .range(0, values.length)
                .reduce(0, (acc, valIndex) -> acc + values[(int)valIndex] * filter[(int)valIndex]);

//        System.out.println(filterResultDiff);
        return Math.min(values[4] + filterResultDiff, 255);
    }

    private static long applyFilterV2(ImageData id, int pixelIndex, int channel) {
        long filterResultDiff = IntStream.range(0, 3*3).mapToObj((valueIndex) -> {
            long pixelX = indexToX(pixelIndex, id);
            long pixelY = indexToY(pixelIndex, id);

            long offsetX = (valueIndex % 3) - 1; // convert X from a 1D index to a 2D index and then move from [0,2] to [-1,1]
            long offsetY = (valueIndex / 3) - 1; // same for Y

            long currPixelX = pixelX + offsetX;
            long currPixelY = pixelY + offsetY;

            long pixelValueIndex = coordsToIndex(currPixelX, currPixelY, id) * 4;
            long finalIndex = pixelValueIndex + channel;

            return (long)id.data.get((int)finalIndex) * filter[valueIndex];
        }).reduce(0L, (res, value) -> res + value);

        return Math.min((long)id.data.get(pixelIndex + channel) + filterResultDiff, 255);
    }

    private static long coordsToIndex(long x, long y, ImageData id) {
        return y * id.width + x;
    }

    private static long indexToX(int index, ImageData id) {
        return index % id.width;
    }

    private static long indexToY(int index, ImageData id) {
        return (long)Math.floor(index / id.width);
    }
}
