import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

    private final List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {

        Set<MatrixCoordinate> result = new HashSet<>();

        for(int row = 0; row < values.size(); row++) {
            List<Integer> rowList = values.get(row);
            Integer max = Collections.max(rowList);

            for(int col = 0; col < rowList.size(); col++) {
                Integer num = rowList.get(col);

                if(num.equals(max)) {
                    List<Integer> colList = new ArrayList<>();

                    for(List<Integer> value : values) {
                        colList.add(value.get(col));
                    }

                    Integer min = Collections.min(colList);

                    for(Integer colNum : colList) {
                        if(num.equals(colNum) && num.equals(min)) {
                            MatrixCoordinate matrixCoordinate = new MatrixCoordinate(row + 1, col + 1);

                            result.add(matrixCoordinate);
                        }
                    }
                }
            }

        }

        return result;
    }
}
