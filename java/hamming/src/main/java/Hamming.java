public class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() == 0 && rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if(rightStrand.length() == 0 && leftStrand.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if(leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        int hammingDistance = 0;
        String[] leftStrandArr = leftStrand.split("");
        String[] rightStrandArr = rightStrand.split("");

        for(int i = 0; i < leftStrandArr.length; i++) {
            if(!leftStrandArr[i].equals(rightStrandArr[i])) {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }
}
