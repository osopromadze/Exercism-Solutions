import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Sieve {
    private final int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();

        AtomicInteger num = new AtomicInteger(2);

        while(num.get() <= maxPrime) {
            boolean doesNotHaveDivisorsInList = primes.stream().noneMatch(n -> num.get() % n == 0);

            if(doesNotHaveDivisorsInList) {
                primes.add(num.get());
            }

            num.incrementAndGet();
        }
        
        return primes;

    }
}
