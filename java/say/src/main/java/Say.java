import java.util.HashMap;
import java.util.Map;

public class Say {

    private final Map<Long, String> numberSpellMap = new HashMap<>(){{
        put(0L, "zero");
        put(1L, "one");
        put(2L, "two");
        put(3L, "three");
        put(4L, "four");
        put(5L, "five");
        put(6L, "six");
        put(7L, "seven");
        put(8L, "eight");
        put(9L, "nine");
        put(10L, "10");
        put(11L, "eleven");
        put(12L, "twelve");
        put(13L, "thirteen");
        put(14L, "fourteen");
        put(15L, "fifteen");
        put(16L, "sixteen");
        put(17L, "seventeen");
        put(18L, "eighteen");
        put(19L, "nineteen");
        put(20L, "twenty");
        put(30L, "thirty");
        put(40L, "forty");
        put(50L, "fifty");
        put(60L, "sixty");
        put(70L, "seventy");
        put(80L, "eighty");
        put(90L, "ninety");
        put(100L, "hundred");
        put(1000L, "thousand");
        put(1000000L, "million");
        put(1000000000L, "billion");

    }};

    public String say(long number) {
        if(number < 0 || number >= 1_000_000_000_000L) {
            throw new IllegalArgumentException();
        }

        if(number == 0) {
            return numberSpellMap.get(number);
        }

        StringBuilder result = new StringBuilder(" ");

        long billions = number / 1000000000;
        long millions = number % 1000000000 / 1000000;
        long thousands =  number % 1000000 / 1000;

        if(billions > 0) {
            result
                    .append(sayToThousand(billions))
                    .append(" billion ");
        }

        if(millions > 0) {
            result
                    .append(sayToThousand(millions))
                    .append(" million ");
        }

        if(thousands > 0) {
            result
                    .append(sayToThousand(thousands))
                    .append(" thousand ");
        }

        result.append(sayToThousand(number % 1000));

        return result.toString().trim();
    }

    private String sayToThousand(long num) {
        StringBuilder result = new StringBuilder(" ");

        long hundreds = num / 100;
        long tens = num % 100 / 10;
        long ones = num % 100 % 10;

        if(hundreds > 0) {
            result.append(numberSpellMap.get(hundreds)).append(" hundred ");
        }

        if(tens == 1) {
            result.append(numberSpellMap.get(10 + ones));
        } else if(tens > 1) {
            result.append(numberSpellMap.get(tens * 10));
            if(ones == 0) {
                result.append(" ");
            } else {
                result.append("-");
            }
        }

        if(ones > 0 && tens != 1) {
            result.append(numberSpellMap.get(ones));
        }

        return result.toString().trim();
    }
}
