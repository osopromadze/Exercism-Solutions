import java.util.Arrays;

class Matrix {

    private final String matrixAsString;

    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
    }

    int[] getRow(int rowNumber) {
        String[] arr = matrixAsString.split("\n");

        return Arrays.stream(arr[rowNumber - 1].split(" "))
                .map(Integer::parseInt)
                .mapToInt(x -> x)
                .toArray();
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(matrixAsString.split("\n"))
                .map(el -> el.split(" ")[columnNumber - 1])
                .map(Integer::parseInt)
                .mapToInt(x -> x)
                .toArray();
    }
}
