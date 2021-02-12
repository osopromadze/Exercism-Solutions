import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Yacht {

    private final int[] dice;
    private final YachtCategory yachtCategory;
    private int min;
    private int max;
    private long countOfDistinctElements;
    private int sum;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
        setMin();
        setMax();
        setCountOfDistinctElements();
        setSum();
    }

    int score() {
        switch(yachtCategory) {
            case ONES:
                return calculateOnesToSixes(1);
            case TWOS:
                return calculateOnesToSixes(2);
            case THREES:
                return calculateOnesToSixes(3);
            case FOURS:
                return calculateOnesToSixes(4);
            case FIVES:
                return calculateOnesToSixes(5);
            case SIXES:
                return calculateOnesToSixes(6);
            case FULL_HOUSE:
                return calculateFullHouse();
            case FOUR_OF_A_KIND:
                return calculateFourOfAKind();
            case LITTLE_STRAIGHT:
                return calculateLittleStraight();
            case BIG_STRAIGHT:
                return calculateBigStraight();
            case CHOICE:
                return calculateChoice();
            case YACHT:
                return calculateYacht();
            default:
                return 0;
        }
    }

    private int calculateOnesToSixes(int num) {
        long count = Arrays.stream(dice)
                .filter(n -> n == num)
                .count();
        return num * Math.toIntExact(count);
    }

    private int calculateFullHouse() {
        int sum = getStreamOfGroupedValuesInArray()
                // filter list with size 2 or 3 as the rule of Full House
                .filter(v -> v.size() == 3 || v.size() == 2)
                // get the sum of list sizes in filtered stream
                // for example {1, 1, 1} and {4, 4} will give us sum of 5 and we have full house
                // {1, 1} and {4, 4} will give 4
                .map(List::size)
                .mapToInt(Integer::intValue)
                .sum();
        return sum == 5 ? this.sum : 0;
    }

    private int calculateFourOfAKind() {
        return getStreamOfGroupedValuesInArray()
                // if one of the list size in stream is more than 4, means that we have Four of a Kind
                .filter(v -> v.size() >= 4)
                // get sum of values
                .map(list -> list.stream()
                        .limit(4)
                        .mapToInt(Integer::intValue)
                        .sum()
                )
                .findFirst()
                .orElse(0);
    }

    private int calculateLittleStraight() {
        return countOfDistinctElements == 5 && min == 1 && max == 5 ? 30 : 0;
    }

    private int calculateBigStraight() {
        return countOfDistinctElements == 5 && min == 2 && max == 6 ? 30 : 0;
    }

    private int calculateChoice() {
        return sum;
    }

    private int calculateYacht() {
        return countOfDistinctElements == 1 ? 50 : 0;
    }

    private Stream<List<Integer>> getStreamOfGroupedValuesInArray() {
        return Arrays.stream(dice)
                .boxed()
                // group by similar values as Map<Integer, List<Integer>>
                .collect(Collectors.groupingBy(s -> s))
                // Returns a Collection of the values in this map as Collection<List<Integer>>
                .values()
                .stream();
    }

    private void setSum() {
        sum = Arrays.stream(dice).sum();
    }

    private void setMax() {
        max = Arrays.stream(dice).max().orElse(0);
    }

    private void setMin() {
        min = Arrays.stream(dice).min().orElse(0);
    }

    private void setCountOfDistinctElements() {
        countOfDistinctElements = Arrays.stream(dice)
                .distinct()
                .count();
    }

}
