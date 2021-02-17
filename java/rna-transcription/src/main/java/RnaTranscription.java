import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class RnaTranscription {

    private final Map<String, String> map = new HashMap<>() {{
        put("G", "C");
        put("C", "G");
        put("T", "A");
        put("A", "U");
    }};

    String transcribe(String dnaStrand) {
        return Arrays.stream(dnaStrand.split(""))
                .filter(map::containsKey)
                .map(map::get)
                .collect(Collectors.joining());
    }

}
