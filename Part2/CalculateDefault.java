package Part2;

/**
 * Created by Nick Maiorano.
 */
public class CalculateDefault {

    public static void main(String[] args)
    {
        CalculatorDefault multiply = (x, y) -> x * y;
        System.out.println(multiply.defaultMultiply(10, 20));
        System.out.println(CalculatorDefault.multiplyStatic(10, 20));
    }
}
