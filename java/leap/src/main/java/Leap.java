import java.util.stream.Stream;

class Leap {

    boolean isLeapYear(int year) {
        return Stream.of(year)
                .filter(y -> y % 4 == 0)
                .anyMatch(y -> y % 100 != 0 || (y % 400 == 0));
    }

}
