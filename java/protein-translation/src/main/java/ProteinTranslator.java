import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

    private Map<String, String> codonProteinMap = new HashMap<>(){
        {
            put("AUG", "Methionine");
            put("UUU", "Phenylalanine"); put("UUC", "Phenylalanine");
            put("UUA", "Leucine"); put("UUG", "Leucine");
            put("UCU", "Serine"); put("UCC", "Serine");put("UCA", "Serine"); put("UCG", "Serine");
            put("UAU", "Tyrosine"); put("UAC", "Tyrosine");
            put("UGU", "Cysteine"); put("UGC", "Cysteine");
            put("UGG", "Tryptophan");
            put("UAA", "STOP"); put("UAG", "STOP"); put("UGA", "STOP");
        }
    };

    List<String> translate(String rnaSequence) {
        List<String> result = new ArrayList<>();

        int start = 0;
        int end = 3;

        while(end <= rnaSequence.length()) {
            String codon = rnaSequence.substring(start, end);
            if(codonProteinMap.containsKey(codon)) {
                if(codonProteinMap.get(codon).equals("STOP")) {
                    return result;
                }

                result.add(codonProteinMap.get(codon));
            }

            start += 3;
            end += 3;
        }

        return result;
    }
}
