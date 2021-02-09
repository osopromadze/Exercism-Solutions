import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private final long gigaSecond = 1000000000;
    private final LocalDateTime dateTime;

    public Gigasecond(LocalDate moment) {
        dateTime = moment.atStartOfDay().plusSeconds(gigaSecond);
    }

    public Gigasecond(LocalDateTime moment) {
        dateTime = moment.plusSeconds(gigaSecond);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
