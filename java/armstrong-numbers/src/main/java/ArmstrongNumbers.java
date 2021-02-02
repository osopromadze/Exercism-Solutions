import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        String num = String.valueOf(numberToCheck);
        int length = num.length();

        AtomicInteger result = new AtomicInteger(0);

        Arrays.stream(num.split("")).forEach(n -> result.getAndAdd((int) Math.pow(Double.parseDouble(n), length)));

        return result.get() == numberToCheck;

    }

}
