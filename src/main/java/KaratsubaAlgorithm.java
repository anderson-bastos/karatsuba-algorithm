import java.math.BigInteger;

public class KaratsubaAlgorithm {

    public static BigInteger multiplication(BigInteger num1, BigInteger num2) {
        if(num1.intValue() < 10 || num2.intValue() < 10)
            return num1.multiply(num2);

        int sizeOfNumbers = sizeOfTheNumbers(num1, num2);

        BigNumber numberOne = formatPairOfValues(num1, sizeOfNumbers);
        BigInteger highOne = numberOne.getFirstPart();
        BigInteger lowOne = numberOne.getSecondPart();

        BigNumber numberTwo = formatPairOfValues(num2, sizeOfNumbers);
        BigInteger highTwo = numberTwo.getFirstPart();
        BigInteger lowTwo = numberTwo.getSecondPart();

        BigInteger firstStep = (highOne.multiply(highTwo));
        BigInteger secondStep = (lowOne.multiply(lowTwo));
        BigInteger thirdStep = (highOne.add(lowOne)).multiply(highTwo.add(lowTwo));
        BigInteger fourthStep = thirdStep.subtract(secondStep).subtract(firstStep);

        return firstStep.multiply(BigInteger.valueOf((long) Math.pow(10, sizeOfNumbers*2)))
                .add(secondStep)
                .add(fourthStep.multiply(BigInteger.valueOf((long) Math.pow(10, sizeOfNumbers))));
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
