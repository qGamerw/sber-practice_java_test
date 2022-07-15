package annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomClassTest {
    @CustomAnnotation(command = "first", queueNumber = 1)
    public String firstCommand() {
        return "firstCommand complete!";
    }

    @CustomAnnotation(command = "second", queueNumber = 2)
    public String secondCommand() {
        return "secondCommand complete!";
    }

    @CustomAnnotation(command = "third", queueNumber = 3)
    public String thirdCommand() {
        return "thirdCommand complete!";
    }

    private Map<Method, Integer> getAnnotationsMethods() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(elem -> elem.isAnnotationPresent(CustomAnnotation.class))
                .collect(Collectors.toMap(Function.identity(),
                        value -> value.getAnnotation(CustomAnnotation.class).queueNumber()));
    }

    private void usingMethods(Method method) throws NoSuchMethodException {
        Map<Method, Integer> map = getAnnotationsMethods();
        int methodNumber = map.get(method);

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(item -> {
                    try {
                        if (item.getValue() <= methodNumber)
                            System.out.println(item.getKey().invoke(this));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    @Test
    public void taskTest3() {
        System.out.println(getAnnotationsMethods());
    }

    @Test
    public void taskTest4() {
        try {
            usingMethods(this.getClass().getDeclaredMethod("thirdCommand"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
