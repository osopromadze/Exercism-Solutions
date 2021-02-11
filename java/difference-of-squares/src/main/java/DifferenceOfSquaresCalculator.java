import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = IntStream.range(1, input + 1).sum();
        return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.range(1, input + 1)
                .map(n -> n * n)
                .sum();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
