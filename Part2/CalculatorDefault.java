package Part2;

/**
 * Created by Nick Maiorano.
 */
@FunctionalInterface
public interface CalculatorDefault {

    public int calculate(int x, int y);

    default int defaultMultiply(int x, int y)
    {
        return x * y;
    }

    static int multiplyStatic(int x, int y)
    {
       return x * y;
    }
}
