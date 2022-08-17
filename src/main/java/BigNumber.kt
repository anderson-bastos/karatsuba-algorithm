import java.math.BigInteger;

public class BigNumber {

    private BigInteger firstPart;
    private BigInteger secondPart;

    public BigNumber(BigInteger firstPart, BigInteger secondPart) {
        this.firstPart = firstPart;
        this.secondPart = secondPart;
    }

    public BigInteger getFirstPart() {
        return firstPart;
    }

    public void setFirstPart(BigInteger firstPart) {
        this.firstPart = firstPart;
    }

    public BigInteger getSecondPart() {
        return secondPart;
    }

    public void setSecondPart(BigInteger secondPart) {
        this.secondPart = secondPart;
    }
}
