package Part4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuickSortFunctional
{
    public static List<Integer> functionalSort(List<Integer> array) {
        List<Integer> returnArray = array;

        if (array.size() > 1) {
            // Step 1
            int mid = array.get(array.size() / 2);

            // Step 2
            Map<Integer, List<Integer>> map = array.stream().
                    collect(Collectors.groupingBy(i -> i < mid ? 0 : i == mid ? 1 : 2));

            // Step 3
            List<Integer> left = functionalSort(map.getOrDefault(0, new ArrayList<>()));
            List<Integer> middle = map.getOrDefault(1, new ArrayList<>());
            List<Integer> right = functionalSort(map.getOrDefault(2, new ArrayList<>()));

            left.addAll(middle);
            left.addAll(right);

            returnArray = left;
        }

        return returnArray;
    }

    public static List<Integer> functionalSortParallel(List<Integer> array) {
        List<Integer> returnArray = array;

        if (array.size() > 1) {
            // Step 1
            int mid = array.get(array.size() / 2);

            // Step 2
            Map<Integer, List<Integer>> map = array.stream().parallel().
                    collect(Collectors.groupingBy(i -> i < mid ? 0 : i == mid ? 1 : 2));

            // Step 3
            List<Integer> left = functionalSort(map.getOrDefault(0, new ArrayList<>()));
            List<Integer> middle = map.getOrDefault(1, new ArrayList<>());
            List<Integer> right = functionalSort(map.getOrDefault(2, new ArrayList<>()));

            left.addAll(middle);
            left.addAll(right);

            returnArray = left;
        }

        return returnArray;
    }

}