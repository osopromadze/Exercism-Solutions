import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {

    private Map<Integer, String> numbers;
    private Map<Integer, String> verses;

    public TwelveDays() {
        fillNumbers();
        fillVerses();
    }

    private void fillVerses() {
        verses = new HashMap<>();

        verses.put(1, "a Partridge in a Pear Tree");
        verses.put(2, "two Turtle Doves");
        verses.put(3, "three French Hens");
        verses.put(4, "four Calling Birds");
        verses.put(5, "five Gold Rings");
        verses.put(6, "six Geese-a-Laying");
        verses.put(7, "seven Swans-a-Swimming");
        verses.put(8, "eight Maids-a-Milking");
        verses.put(9, "nine Ladies Dancing");
        verses.put(10, "ten Lords-a-Leaping");
        verses.put(11, "eleven Pipers Piping");
        verses.put(12, "twelve Drummers Drumming");
    }

    private void fillNumbers() {
        numbers = new HashMap<>();

        numbers.put(1, "first");
        numbers.put(2, "second");
        numbers.put(3, "third");
        numbers.put(4, "fourth");
        numbers.put(5, "fifth");
        numbers.put(6, "sixth");
        numbers.put(7, "seventh");
        numbers.put(8, "eighth");
        numbers.put(9, "ninth");
        numbers.put(10, "tenth");
        numbers.put(11, "eleventh");
        numbers.put(12, "twelfth");
    }

    private String getPrefix(int verseNumber) {
        return "On the " + numbers.get(verseNumber) + " day of Christmas my true love gave to me: ";
    }

    String verse(int verseNumber) {
        StringBuilder sb = new StringBuilder();

        sb.append(getPrefix(verseNumber));

        while(verseNumber > 0) {
            sb.append(verses.get(verseNumber));

            if(verseNumber != 1) {
                sb.append(", ");
            }

            if(verseNumber == 2) {
                sb.append("and ");
            }

            if(verseNumber == 1) {
                sb.append(".\n");
            }

            verseNumber--;
        }

        return sb.toString();
    }

    String verses(int startVerse, int endVerse) {

        StringBuilder sb = new StringBuilder();

        for(int i = startVerse; i <= endVerse; i++) {
            sb.append(verse(i));

            if(i != endVerse) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
    String sing() {
        return verses(1, 12);
    }
}
