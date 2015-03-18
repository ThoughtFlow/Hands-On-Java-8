package Part2;

/**
 * Created by Nick Maiorano.
 */
public class Calculate {

    private static void someMethod(Calculator calc1, Calculator calc2)
    {
        System.out.println(calc1.calculate(10, 20));
        System.out.println(calc2.calculate(20, 10));
    }

    private static void anotherMethod(Calculator calc)
    {
        System.out.println(calc.calculate(1, 2));
    }

    public static void main(String[] args)
    {
        Calculator multiply = (x, y) -> x * y;
        Calculator divide = (x, y) -> x / y;

        int product = multiply.calculate(10, 20);
        int quotient = divide.calculate(100, 20);
        System.out.println(product);
        System.out.println(quotient);

        Calculator mm = (x, y) -> x * y;
        System.out.println(multiply.equals(mm));

        someMethod(multiply, divide);
        anotherMethod((x, y) -> x ^ y);
    }
}
