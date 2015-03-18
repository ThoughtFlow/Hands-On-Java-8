package Life;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Life {
    public static double execute(String method, boolean isRunnable,
                                 Function<boolean[][], boolean[][]> function, boolean[][] firstGeneration,
                                 int generations) {
        double totalTime = 0;

        if (isRunnable) {
            long start = System.currentTimeMillis();
            LifeView view = new LifeView(method, firstGeneration, 4);
            boolean[][] nextGeneration = firstGeneration;
            for (int generationCount = 0; generationCount < generations; ++generationCount) {
                nextGeneration = function.apply(nextGeneration);
                view.displayNextGeneration(nextGeneration, generationCount);
            }

            totalTime = (System.currentTimeMillis() - start) / 1000.0;
        }

        return totalTime;
    }

    public static void main(String[] args) {

        if (args.length != 6) {
            System.err.println("Args: runImperative runSerialStream runParallelStream runParallelStreamPlus size generations");
            System.exit(-1);
        }

        boolean runImperative = Boolean.parseBoolean(args[0]);
        boolean runSerialStream = Boolean.parseBoolean(args[1]);
        boolean runParallelStream = Boolean.parseBoolean(args[2]);
        boolean runParallelPlusStream = Boolean.parseBoolean(args[3]);

        int size = Integer.parseInt(args[4]);
        int generations = Integer.parseInt(args[5]);
        boolean[][] firstGeneration = new boolean[size][size];
        Random r = new Random();
        IntStream.rangeClosed(0, size - 1).forEach(y -> IntStream.rangeClosed(0, size - 1).forEach(x -> firstGeneration[y][x] = Math.abs(r.nextInt()) % 2 == 0));

        System.out.println(execute("Imperative", runImperative, ImperativeLife::getNextGeneration, firstGeneration, generations));
        System.out.println(execute("Functional Serial", runSerialStream, FunctionalLife::getNextGenerationSerial, firstGeneration, generations));
        System.out.println(execute("Functional Parallel", runParallelStream, FunctionalLife::getNextGenerationParallel, firstGeneration, generations));
        System.out.println(execute("Functional Parallel Plus", runParallelPlusStream, FunctionalLife::getNextGenerationFunctionalPlus, firstGeneration, generations));
    }
}
