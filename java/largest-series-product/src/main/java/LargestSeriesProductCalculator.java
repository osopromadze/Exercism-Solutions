import java.util.Arrays;

class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        boolean hasAnyLetter = inputNumber.chars().anyMatch(Character::isLetter);

        if(hasAnyLetter) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }

        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if(numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        if(inputNumber.length() < numberOfDigits) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        long result = Long.MIN_VALUE;
        String[] inputNumberArr = inputNumber.split("");
        int index = 0;

        while(index <= inputNumberArr.length - numberOfDigits ) {
            long multiplicationResult = Arrays.stream(inputNumberArr)
                    .skip(index)
                    .limit(numberOfDigits)
                    .mapToLong(Long::new)
                    .reduce(1, (total, element) -> total * element);

            result = Math.max(result, multiplicationResult);

            index++;
        }

        return result;
    }
}
