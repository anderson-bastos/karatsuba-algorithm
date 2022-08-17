import java.math.BigInteger
import kotlin.math.floor
import kotlin.math.pow

object KaratsubaAlgorithm {
    @JvmStatic
    fun multiplication(num1: BigInteger, num2: BigInteger): BigInteger {
        if (num1.toInt() < 10 || num2.toInt() < 10)
            return num1.multiply(num2)

        val sizeOfNumbers = sizeOfTheNumbers(num1, num2)
        val numberOne = formatPairOfValues(num1, sizeOfNumbers)

        val highOne = numberOne.firstPart
        val lowOne = numberOne.secondPart
        val numberTwo = formatPairOfValues(num2, sizeOfNumbers)

        val highTwo = numberTwo.firstPart
        val lowTwo = numberTwo.secondPart

        val firstStep = highOne.multiply(highTwo)
        val secondStep = lowOne.multiply(lowTwo)
        val thirdStep = highOne.add(lowOne).multiply(highTwo.add(lowTwo))
        val fourthStep = thirdStep.subtract(secondStep).subtract(firstStep)

        return firstStep.multiply(BigInteger.valueOf(10.0.pow((sizeOfNumbers * 2).toDouble()).toLong()))
            .add(secondStep)
            .add(fourthStep.multiply(BigInteger.valueOf(10.0.pow(sizeOfNumbers.toDouble()).toLong())))
    }

    private fun sizeOfTheNumbers(num1: BigInteger, num2: BigInteger) =
        floor((log10(num1).coerceAtMost(log10(num2)) / 2).toDouble()).toInt()


    private fun log10(num1: BigInteger): Int {
        return (kotlin.math.log10(num1.toDouble()) + 1).toInt()
    }

    private fun formatPairOfValues(number: BigInteger, halfOfTheText: Int): BigNumber {
        val numberAsString = number.toString()
        val lengthOfNumber = numberAsString.length
        return BigNumber(
            BigInteger(numberAsString.substring(0, halfOfTheText)),
            BigInteger(numberAsString.substring(halfOfTheText, lengthOfNumber))
        )
    }
}