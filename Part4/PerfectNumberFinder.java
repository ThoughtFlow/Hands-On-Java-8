package Part4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by Nick Maiorano.
 */
public class PerfectNumberFinder {

    private static boolean isPerfect(long n)
    {
        return n > 0 &&
                LongStream.rangeClosed(1, n / 2).
                        filter(i -> n % i == 0).
                            reduce(0, (l, r) -> l + r) == n;
    }


    public static void main(String[] args)
    {
        long range = Long.parseLong(args[0]);

        System.out.println("Is 6 perfect number: " + isPerfect(6));
        System.out.println("Is 1000 perfect number: " + isPerfect(1000));
        System.out.println("Is 8128 perfect number: " + isPerfect(8128));
        System.out.println("Is 33550336 perfect number: " + isPerfect(33550336));

        System.out.println("Perfect numbers for: " + range);
        List<Long> perfectNumbers =
                LongStream.rangeClosed(1, range).
                        filter(PerfectNumberFinder::isPerfect).mapToObj(l -> l).
//                        collect(ArrayList<Long>::new, ArrayList<Long>::add, ArrayList<Long>::addAll);
                            collect(Collectors.toList());


        perfectNumbers.forEach(System.out::println);
    }
}
