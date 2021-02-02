import java.util.HashMap;
import java.util.Map;

class Darts {

    final double x;
    final double y;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        double value = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        if(value > 10) return 0;
        else if(value > 5) return 1;
        else if(value > 1) return 5;
        else return 10;
    }

}
