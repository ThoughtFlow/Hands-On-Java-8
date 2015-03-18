package Part2;

/**
 * Created by Nick Maiorano.
 */
public class MaxFinder {

    public int maxFinder(int x, int y)
    {
        return x > y ? x : y;
    }

    public static void main(String[] args)
    {
        Calculator maxFinder = (x, y) -> Math.max(x, y);
        Calculator maxFinder2 = Math::max;

        System.out.println(maxFinder.calculate(1, 2));
        System.out.println(maxFinder2.calculate(1, 2));

        MaxFinder maxFinderInstance = new MaxFinder();
        Calculator maxFinder3 = maxFinderInstance::maxFinder;
        System.out.println(maxFinder3.calculate(1, 2));
    }
}
