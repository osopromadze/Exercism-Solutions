import java.util.Arrays;

class Acronym {

    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        return Arrays
                .stream(phrase.replaceAll("[^a-zA-Z']", " ").split(" "))
                .map(String::trim)
                .filter(w -> w.length() > 0)
                .map(w -> w.split("")[0])
                .map(String::toUpperCase)
                .reduce("", String::concat);
    }

}
