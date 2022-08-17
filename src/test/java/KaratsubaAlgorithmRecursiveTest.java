import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class KaratsubaAlgorithmRecursiveTest {
    @Test
    public void testMultiplyBigValues() {
        Assertions.assertEquals(
            BigInteger.valueOf(7006652),
            KaratsubaAlgorithmRecursive.multiplication(BigInteger.valueOf(1234), BigInteger.valueOf(5678))
        );
    }

    @Test
    public void courseraChallenge() {
        Assertions.assertEquals(
                new BigInteger(
                        "8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184"
                ),
                KaratsubaAlgorithmRecursive.multiplication(
                        new BigInteger("3141592653589793238462643383279502884197169399375105820974944592"),
                        new BigInteger("2718281828459045235360287471352662497757247093699959574966967627")
                )
        );
    }
}
