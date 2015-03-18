package Part3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nick Maiorano.
 */
public class MapComprehensions {

    private final Map<Integer, List<String>> movieDb = new HashMap<>();

    private void printKeySet() {
        System.out.println("===========");
        movieDb.keySet().forEach(System.out::println);
    }

    private void addMovie(Integer year, String movie) {
        movieDb.computeIfAbsent(year, k -> new LinkedList<>());

        movieDb.compute(year, (k, v) -> {
            v.add(movie);
            return v;
        });
    }

    public static void main(String[] args) {
        MapComprehensions mapComprehensions = new MapComprehensions();
        mapComprehensions.addMovie(1930, "Soup to nuts");
        mapComprehensions.printKeySet();

        mapComprehensions.addMovie(1933, "Meet the Baron");
        mapComprehensions.addMovie(1933, "Dancing lady");
        mapComprehensions.printKeySet();
    }

}
