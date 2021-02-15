import java.util.stream.Stream;

class Triangle {

    private final long distinctSideCount;

    Triangle(double side1, double side2, double side3) throws TriangleException {

        boolean triangleHasAnyZeroLengthSide = Stream.of(side1, side2, side3)
                .anyMatch(s -> s == 0.0);

        boolean isValidTriangle = side1 + side2 >= side3 && side1 + side3 >= side2 && side2 + side3 >= side1;

        if(triangleHasAnyZeroLengthSide || !isValidTriangle) {
            throw new TriangleException();
        }

        distinctSideCount = Stream.of(side1, side2, side3)
                .distinct()
                .count();
    }

    boolean isEquilateral() {
        return distinctSideCount == 1;
    }

    boolean isIsosceles() {
        return distinctSideCount == 1 || distinctSideCount == 2;
    }

    boolean isScalene() {
        return distinctSideCount == 3;
    }

}
