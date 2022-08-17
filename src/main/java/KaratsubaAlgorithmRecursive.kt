import java.math.BigInteger;

public class KaratsubaAlgorithmRecursive {

    public static BigInteger multiplication(BigInteger num1, BigInteger num2) {
        if(num1.intValue() < 100 || num2.intValue() < 100)
            return num1.multiply(num2);

        int sizeOfNumbers = sizeOfTheNumbers(num1, num2);

        BigNumber numberOne = formatPairOfValues(num1, sizeOfNumbers);
        BigInteger highOne = numberOne.getFirstPart();
        BigInteger lowOne = numberOne.getSecondPart();

        BigNumber numberTwo = formatPairOfValues(num2, sizeOfNumbers);
        BigInteger highTwo = numberTwo.getFirstPart();
        BigInteger lowTwo = numberTwo.getSecondPart();

        BigInteger z0 = multiplication(lowOne, lowTwo); // z0
        BigInteger z1 = multiplication((lowOne.add(highOne)), (lowTwo.add(highTwo))); // z1
        BigInteger z2 = multiplication(highOne, highTwo); // z2

        BigInteger step1 = z2.multiply(BigInteger.valueOf((long)Math.pow(10, sizeOfNumbers*2)));
        BigInteger step2 = z1.subtract(z2).subtract(z0).multiply(BigInteger.valueOf((long) Math.pow(10, sizeOfNumbers)));

        return step1.add(step2).add(z0);
    }

    private static int sizeOfTheNumbers(BigInteger num1, BigInteger num2) {
        return (int) Math.floor(Math.min( log10(num1), log10(num2)) /2);
    }

    private static int log10(BigInteger num1) {
        return (int) (Math.log10(num1.doubleValue()) + 1);
    }

    private static BigNumber formatPairOfValues(BigInteger number, int halfOfTheText) {
        String numberAsString = String.valueOf(number);
        int lengthOfNumber = numberAsString.length();

        return new BigNumber(
            new BigInteger(numberAsString.substring(0, halfOfTheText)),
            new BigInteger(numberAsString.substring(halfOfTheText, lengthOfNumber))
        );
    }
}
