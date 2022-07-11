package lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaProgram {
    public static int getNum(OneFunctionalInterface one) {
        return one.getNum();
    }

    public static int func(TwoFunctionalInterface two) {
        return two.doOneNum(10);
    }

    public static boolean equalsNums(ThreeFunctionalInterface three) {
        return three.booleanFunc(10, 15);
    }

    private static void extracted(NullParameterFunction param) {
        param.doNullSomething();
    }

    public static void main(String[] args) {

        extracted(new NullParameterFunction() {
            @Override
            public void doNullSomething() {
                System.out.println("Called via an anonymous class");
            }

        });

        extracted(() -> System.out.println("Called via Lambda"));

        //4
        Function<Integer, Double> half = a -> a / 2.0;
        System.out.println(half.apply(10));

        Predicate<Integer> predicate = a -> (a > 18);
        System.out.println("a > 18: " + predicate.test(10));

        String srt = "Hello";
        Supplier<String> supplierStr = () -> srt.toUpperCase();
        System.out.println(supplierStr.get());

        Consumer<String> print = x -> System.out.println(x);
        print.accept("Hello");
    }
}
