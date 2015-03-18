package Part4;

import Part4.QuickSortFunctional;
import Part4.QuickSortImperative;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.List;

public class QuickSort
{
    private static double sort(Function<List<Integer>, List<Integer>> function, List<Integer> randomNumbers)
    {
        if (randomNumbers.stream().reduce(0, (l, r) -> l > -1 && l <= r ? r : -1) != -1)
        {
            System.out.println("Already sorted");
        }
        long start = System.currentTimeMillis();
        List<Integer> sortedNumbers = function.apply(randomNumbers);
        double end = (System.currentTimeMillis() - start) / 1000.0;
        if (sortedNumbers.stream().reduce(0, (l, r) -> l > -1 && l <= r ? r : -1) == -1)
        {
            System.out.println("Not well sorted");
        }

        return end;
    }

    public static void main(String[] args)
    {
        int size = Integer.parseInt(args[0]);

        ArrayList<Integer> originalRandomNumbers = new ArrayList<>();
        Random rand = new Random();
        IntStream.range(0, size).forEach(i -> originalRandomNumbers.add(Math.abs(rand.nextInt())));

        System.out.println("For list size = " + size);
        for (int index = 0; index < 2; ++index)
        {
            ArrayList<Integer> copiedList = new ArrayList<>(originalRandomNumbers);
            System.out.println("Imperative sort:          " + sort(list -> QuickSortImperative.imperativeQuickSort((ArrayList<Integer>) list, 0, size - 1), copiedList));
            copiedList = new ArrayList<>(originalRandomNumbers);
            System.out.println("Functional sort:          " + sort(QuickSortFunctional::functionalSort, copiedList));
            copiedList = new ArrayList<>(originalRandomNumbers);
            System.out.println("Functional sort parallel: " + sort(QuickSortFunctional::functionalSortParallel, copiedList));
        }
    }
}
