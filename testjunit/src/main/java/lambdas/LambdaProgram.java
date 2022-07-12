package lambdas;

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
}
