import java.util.Arrays;

class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        int length = words.length;
        if(length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for(int i = 1; i < length; i++) {
            result.append("For want of a ")
                    .append(words[i - 1])
                    .append(" the ")
                    .append(words[i])
                    .append(" was lost.")
                    .append("\n");
        }

        result.append("And all for the want of a ")
                .append(words[0])
                .append(".");

        return result.toString();

    }

}
