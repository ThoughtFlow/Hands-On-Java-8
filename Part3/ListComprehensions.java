package Part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Created by Nick Maiorano.
 */
public class ListComprehensions {

    private static void forEach(List<String> stooges) {
        System.out.println("===========");
        stooges.forEach(System.out::println);
    }

    private static void replaceAll(List<String> stooges) {

        UnaryOperator<String> feminize = s -> "Larry".equals(s) ? "Lara" : "Moe".equals(s) ? "Maude" : "Shirley";

        stooges.replaceAll(feminize);
        forEach(stooges);
    }

    private static void removeIf(ArrayList<String> stooges)
    {
        Predicate<String> moeRemover = "Moe"::equals;
        stooges.removeIf(moeRemover);
        forEach(stooges);
    }

    public static void main(String[] args) {
        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");

        ListComprehensions.forEach(new ArrayList<>(stooges));
        ListComprehensions.replaceAll(new ArrayList<>(stooges));
        ListComprehensions.removeIf(new ArrayList<>(stooges));
    }
}
