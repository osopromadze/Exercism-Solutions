import java.util.stream.IntStream;

class PrimeCalculator {

    int nth(int nth) {
        if(nth < 1) {
            throw new IllegalArgumentException();
        }

        int count = 1;

        for(int i = 2; i < Integer.MAX_VALUE; i++) {
            if(isPrime(i)) {
                if(count == nth) {
                    return i;
                }
                count++;
            }
        }

        return 0;
    }

    boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

}
