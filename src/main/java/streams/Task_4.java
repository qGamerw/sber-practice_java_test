package streams;

import java.util.Optional;

public class Task_4 {
    public static void main(String[] args) {
        TestClass testClass = null;
        testClass = Optional.ofNullable(testClass).orElseGet(TestClass::new);
        System.out.println(testClass.getName());
    }
}
