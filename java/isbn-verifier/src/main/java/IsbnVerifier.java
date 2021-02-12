class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        stringToVerify = stringToVerify.replaceAll("-", "");

        if(stringToVerify.length() != 10) {
            return false;
        }

        String[] arrStringToVerify = stringToVerify.split("");

        int result = 0;
        int numToMultiply = 1;

        for(int i = 9; i >= 0; i--) {
            Integer n = getAsInteger(arrStringToVerify[i]);

            if(i == 9 && arrStringToVerify[i].equals("X")) {
                n = 10;
            }

            if(n == null) {
                return false;
            }
            result += n * numToMultiply;
            numToMultiply++;
        }

        return result % 11 == 0;
    }

    private Integer getAsInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
