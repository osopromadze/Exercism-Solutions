import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class KindergartenGarden {

    private final String garden;
    private final Map<String, Integer> studentsMap = new HashMap<>() {{
        put("Alice", 1);
        put("Bob", 2);
        put("Charlie", 3);
        put("David", 4);
        put("Eve", 5);
        put("Fred", 6);
        put("Ginny", 7);
        put("Harriet", 8);
        put("Ileana", 9);
        put("Joseph", 10);
        put("Kincaid", 11);
        put("Larry", 12);
    }};

    KindergartenGarden(String garden) {
        this.garden = garden;
    }

    List<Plant> getPlantsOfStudent(String student) {
        return Arrays.stream(garden.split("\n"))
                .map(row -> row.chars()
                        .skip((studentsMap.get(student) - 1) * 2L)
                        .limit(2)
                        .mapToObj(plantChar -> Plant.getPlant((char) plantChar))
                        .collect(Collectors.toList())
                )
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
