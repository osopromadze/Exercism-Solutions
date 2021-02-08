import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PangramChecker {

    public boolean isPangram(String input) {
        List<Integer> alphabetCharCodes = IntStream.range(97, 123).boxed().collect(Collectors.toList());

        for(char ch : input.toLowerCase().toCharArray()) {
            if(alphabetCharCodes.isEmpty()) {
                return true;
            }

            alphabetCharCodes.remove(new Integer(ch));
        }

        return alphabetCharCodes.isEmpty();
    }

}
