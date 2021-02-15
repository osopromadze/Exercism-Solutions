import java.util.Arrays;
import java.util.stream.IntStream;

class LuhnValidator {

    boolean isValid(String candidate) {
        candidate = candidate.replaceAll(" ", "");
        boolean allValidNumbers = candidate.chars().allMatch(Character::isDigit);

        if(!allValidNumbers) {
            return false;
        }

        if(candidate.length() < 2) {
            return false;
        }
        String[] candidateReversedArray = new StringBuilder(candidate).reverse().toString().split("");

        int sum = IntStream.range(0, candidateReversedArray.length)
                .map(i -> {
                    int num = Integer.parseInt(candidateReversedArray[i]);
                    return i % 2 == 1 ? num * 2 : num;
                })
                .map(n -> n > 9 ? n - 9 : n)
                .sum();

        return sum % 10 == 0;
    }

}
