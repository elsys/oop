import java.util.*;

public class NumberProcessor {
    private List<Integer> numbers;

    private NumberProcessor() {}

    public static NumberProcessor fromArray(int[] arr) {
        NumberProcessor np = new NumberProcessor();

        np.numbers = new ArrayList<>();
        for(int i : arr) {
            np.numbers.add(i);
        }

        return np;
    }

    public NumberProcessor map(SingleArgWithResult mapper) {
//        int r = mapper.process(23);

//        List<Integer> res = new ArrayList<>();
//        for(int i : numbers) {
//            res.add(mapper.process(i));
//        }
//        numbers = res;


        for(int i = 0; i < numbers.size(); i++ ) {
//          arr[i] = mapper.process(arr[i])
            numbers.set(
                    i,
                    mapper.process(
                            numbers.get(i)
                    )
            );
        }

//        numbers.replaceAll(mapper::process);

        return this;
    }

    public NumberProcessor filter(SingleArgWithResult fn) {
        List<Integer> res = new ArrayList<>();
        for(int i : numbers) {
            if(fn.process(i) == 1)
                res.add(i);
        }
        numbers = res;

        return this;
    }

    public Map<Integer, Vector> groupBy(SingleArgWithResult fn) {
        Map<Integer, Vector> res = new HashMap<>();

        for(int i : numbers) {
            Integer key = fn.process(i);
            if(!res.containsKey(key)) {
                res.put(key, new Vector());
            }

            res.get(key).add(i);
        }

        return res;
    }
}
