package Part2;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

/**
 * Created by Nick Maiorano.
 */
public class CalculateFuncIntf {

    public static void main(String[] args)
    {
        BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
        IntBinaryOperator divide = (x, y) -> x / y;

        int product = multiply.apply(10, 20);
        int quotient = divide.applyAsInt(100, 20);
        System.out.println(product);
        System.out.println(quotient);

    }
}
