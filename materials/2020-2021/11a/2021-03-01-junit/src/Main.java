import java.math.BigInteger;

public class Main {
    BigInteger fibonacci(int target) {
        if(target < 0)
            throw new IllegalArgumentException(
                    "Target cannot be negative"
            );
        //((Integer)1).toString();
        //Integer.parseInt("1234")
        if(target == 0) return new BigInteger("0");
        if(target == 1 || target == 2) return new BigInteger("1");

        return fibonacci(target - 1).add(
               fibonacci(target - 2));
        //return fibonacci(target - 1) +
               //fibonacci(target - 2);
    }
}
