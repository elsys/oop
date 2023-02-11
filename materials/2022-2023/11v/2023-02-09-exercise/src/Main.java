import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Line> myLines = FileHelper.<Line>readFile(
                    "./data/test.txt",
//                    new ILineTransformer() {
//                        @Override
//                        public Object transform(String[] tokens) {
//                            return new Line(
//                                Float.parseFloat(tokens[0]),
//                                Float.parseFloat(tokens[1]),
//                                Float.parseFloat(tokens[2]),
//                                Float.parseFloat(tokens[3]),
//                                tokens[4]
//                            );
//                        }
//                    }
                    (tokens) ->
                        new Line(
                            Float.parseFloat(tokens[0]),
                            Float.parseFloat(tokens[1]),
                            Float.parseFloat(tokens[2]),
                            Float.parseFloat(tokens[3]),
                            tokens[4]
                        )
            );
            myLines.forEach((l) -> System.out.println(l));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
