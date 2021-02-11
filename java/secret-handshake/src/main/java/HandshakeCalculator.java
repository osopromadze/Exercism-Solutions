import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HandshakeCalculator {

    private final Map<Integer, Signal> mapping = new HashMap<>();

    public HandshakeCalculator() {
        mapping.put(1, Signal.WINK);
        mapping.put(2, Signal.DOUBLE_BLINK);
        mapping.put(4, Signal.CLOSE_YOUR_EYES);
        mapping.put(8, Signal.JUMP);
    }

    List<Signal> calculateHandshake(int number) {
        List<Signal> signals = new ArrayList<>();

        mapping.forEach((key, value) -> {
            if ((number & key) == key) {
                signals.add(value);
            }
        });

        if ((number & 16) == 16) {
            Collections.reverse(signals);
        }

        return signals;
    }

}
