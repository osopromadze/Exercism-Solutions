import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ReverseString {

    String reverse(String inputString) {
        final List<String> list = Arrays.asList(inputString.split(""));
        Collections.reverse(list);
        return String.join("", list);
    }
  
}
