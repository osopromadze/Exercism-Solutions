import java.util.stream.IntStream;
import java.util.stream.Stream;

class NaturalNumber {

    private int number;

    public NaturalNumber(int number) {
        if(number < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    public Classification getClassification() {
        int sum = IntStream.range(1, number / 2 + 1)
                .filter(n -> number % n == 0)
                .sum();

        if(sum == number) {
            return Classification.PERFECT;
        } else if(sum > number) {
            return Classification.ABUNDANT;
        } else {
            return Classification.DEFICIENT;
        }
    }
}
