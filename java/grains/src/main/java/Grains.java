import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if(square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }

        BigInteger result = new BigInteger("1");

        for(int i = 2; i <= square; i++) {
            result = result.multiply(BigInteger.valueOf(2));
        }

        return result;
    }

    BigInteger grainsOnBoard() {
        BigInteger totalGrains = new BigInteger("0");

        for(int i = 1; i <= 64; i++) {
            BigInteger grains = grainsOnSquare(i);
            totalGrains = totalGrains.add(grains);
        }

        return totalGrains;
    }

}
