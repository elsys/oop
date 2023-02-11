import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class FileHelper {
    public static <T> List<T> readFile(
            String fileName,
//            ILineTransformer transformer
            Function<String[], T> transformer
    )
            throws FileNotFoundException,
                   IOException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner ss = new Scanner(fis);

        List<T> objects = new LinkedList<>();

        while(ss.hasNext()) {
            String line = ss.nextLine();
            String[] tokens = line.split(" ");

            objects.add(transformer.apply(tokens));
//            objects.add(transformer.transform(tokens));
//            lines.add(new Line(
//                    Float.parseFloat(tokens[0]),
//                    Float.parseFloat(tokens[1]),
//                    Float.parseFloat(tokens[2]),
//                    Float.parseFloat(tokens[3]),
//                    tokens[4]
//            ));
        }

        fis.close();

        return objects;
    }
}
