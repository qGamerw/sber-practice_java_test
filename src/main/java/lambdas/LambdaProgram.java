package lambdas;

public class LambdaProgram {
    public static int getNum (OneFunctionalInterface one) {
        return one.getNum();
    }
    public static int Func (TwoFunctionalInterface two) {
        return two.doOneNum(10);
    }
    public static boolean equalsNums (ThreeFunctionalInterface three) {
        return three.booleanFunc(10, 15);
    }
    private static void extracted (NullParameterFunction param) {
        param.doNullSomething();
    }

    public static void main (String[] args) {
        int num1 = getNum( () -> 22);
        System.out.println("Num 1: " + num1);

        int num2 = Func(new TwoFunctionalInterface() {
            @Override
            public int doOneNum (int num) {
                int rand = (int)(Math.random()*10);
                System.out.println("Num: " + num + " Random: " + rand);
                return num + rand;
            }
        });
        System.out.println("Num 2: " + num2);

        System.out.println("10 > 15: " + equalsNums( (a,b) -> (a > b) ));
        System.out.println("10 < 15: " + equalsNums( (a,b) -> (a < b) ));
        System.out.println("10 = 15: " + equalsNums( (a,b) -> (a == b) ));
        System.out.println("10 != 15: " + equalsNums( (a,b) -> (a != b) ));

        extracted (new NullParameterFunction () {
            @Override
            public void doNullSomething () {
                System.out.println("Called via an anonymous class");
            };
        });

        extracted ( () -> System.out.println("Called via Lambda") );
    }
}
