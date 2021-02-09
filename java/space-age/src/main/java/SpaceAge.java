import java.math.BigDecimal;
import java.math.RoundingMode;

class SpaceAge {

    private static final double EARTH_YEAR_IN_SECONDS = 31557600;
    private final double seconds;
    private Double ageOnEarth;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    private double roundOnTwoDecimal(double value) {
        return new BigDecimal(value)
                .setScale(2, RoundingMode.HALF_DOWN)
                .doubleValue();
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return roundOnTwoDecimal(seconds / EARTH_YEAR_IN_SECONDS);
    }

    double onMercury() {
        return roundOnTwoDecimal(seconds / EARTH_YEAR_IN_SECONDS / 0.2408467);
    }

    double onVenus() {
        return roundOnTwoDecimal(seconds / EARTH_YEAR_IN_SECONDS / 0.61519726);
    }

    double onMars() {
        return roundOnTwoDecimal(seconds / EARTH_YEAR_IN_SECONDS / 1.8808158);
    }

    double onJupiter() {
        return roundOnTwoDecimal(seconds / EARTH_YEAR_IN_SECONDS / 11.862615);
    }

    double onSaturn() {
        return roundOnTwoDecimal(seconds / EARTH_YEAR_IN_SECONDS / 29.447498);
    }

    double onUranus() {
        return roundOnTwoDecimal(seconds / EARTH_YEAR_IN_SECONDS / 84.016846);
    }

    double onNeptune() {
        return roundOnTwoDecimal(seconds / EARTH_YEAR_IN_SECONDS / 164.79132);
    }

}
