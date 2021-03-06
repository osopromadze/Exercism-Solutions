import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey % 26;
    }

    String rotate(String data) {

        return Arrays.stream(data.split(""))
                .map(s -> s.charAt(0))
                .map(ch -> {
                    if(!Character.isLetter(ch)) {
                        return ch;
                    }

                    int code = ch + shiftKey;

                    if(Character.isUpperCase(ch) && code > 90) {
                        code -= 26;
                    }

                    if(Character.isLowerCase(ch) && code > 122) {
                        code -= 26;
                    }

                    return (char) code;
                })
                .map(Objects::toString)
                .collect(Collectors.joining());
    }

}
