import java.util.Arrays;
import java.util.stream.IntStream;

class SumOfMultiples {

    private final int number;
    private final int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        return IntStream.range(1, number)
                .filter(number -> Arrays.stream(set)
                        .filter(m -> m != 0)
                        .anyMatch(m -> number % m == 0)
                )
                .sum();
    }

}
