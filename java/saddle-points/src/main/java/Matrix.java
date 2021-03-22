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

            for(int i = 0; i < rowList.size(); i++) {
                Integer num = rowList.get(i);

                if(num.equals(max)) {
                    List<Integer> colList = new ArrayList<>();

                    for(List<Integer> value : values) {
                        colList.add(value.get(i));
                    }

                    Integer min = Collections.min(colList);

                    for(Integer colNum : colList) {
                        if(num.equals(colNum) && num.equals(min)) {
                            MatrixCoordinate matrixCoordinate = new MatrixCoordinate(row + 1, i + 1);

                            result.add(matrixCoordinate);
                        }
                    }
                }
            }

        }

        return result;
    }
}
