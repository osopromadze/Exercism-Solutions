import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PangramChecker {

    public boolean isPangram(String input) {
        List<Integer> range = IntStream.range(97, 123).boxed().collect(Collectors.toList());

        for(char ch : input.toLowerCase().toCharArray()) {
            range.remove(new Integer(ch));
        }

        return range.isEmpty();
    }

}
