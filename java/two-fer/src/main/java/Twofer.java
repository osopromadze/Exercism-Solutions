import java.util.Objects;

public class Twofer {
    public String twofer(String name) {
        StringBuilder sb = new StringBuilder();

        sb.append("One for ");
        sb.append(Objects.requireNonNullElse(name, "you"));

        sb.append(", one for me.");

        return sb.toString();
    }
}
