import java.math.BigInteger
import kotlin.math.floor
import kotlin.math.pow

object KaratsubaAlgorithmRecursive {
    @JvmStatic
    fun multiplication(num1: BigInteger, num2: BigInteger): BigInteger {
        if (num1.toInt() < 100 || num2.toInt() < 100)
            return num1.multiply(num2)

        val sizeOfNumbers = sizeOfTheNumbers(num1, num2)

        val numberOne = formatPairOfValues(num1, sizeOfNumbers)
        val highOne = numberOne.firstPart
        val lowOne = numberOne.secondPart

        val numberTwo = formatPairOfValues(num2, sizeOfNumbers)
        val highTwo = numberTwo.firstPart
        val lowTwo = numberTwo.secondPart

        val z0 = multiplication(lowOne, lowTwo) // z0
        val z1 = multiplication(lowOne.add(highOne), lowTwo.add(highTwo)) // z1
        val z2 = multiplication(highOne, highTwo) // z2
        val step1 = z2.multiply(BigInteger.valueOf(10.0.pow((sizeOfNumbers * 2).toDouble()).toLong()))
        val step2 =
            z1.subtract(z2).subtract(z0).multiply(BigInteger.valueOf(10.0.pow(sizeOfNumbers.toDouble()).toLong()))

        return step1.add(step2).add(z0)
    }

    private fun sizeOfTheNumbers(num1: BigInteger, num2: BigInteger): Int {
        return floor((log10(num1).coerceAtMost(log10(num2)) / 2).toDouble()).toInt()
    }

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