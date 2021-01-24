import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class ResistorColorDuo {
    int value(String[] colors) {
        StringBuilder sb = new StringBuilder();
        int nums = 0;

        for(String color : colors) {
            Integer value = Arrays.asList(colors()).indexOf(color);
            if(nums < 2) {
                nums++;
                sb.append(value);
            }
        }

        return Integer.parseInt(sb.substring(0, nums));
    }

    String[] colors() {
        return new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    }
}
