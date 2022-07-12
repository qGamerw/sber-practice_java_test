package reflections;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTest {
    //1
    @Test
    public void changeFieldPrivateTest() throws NoSuchFieldException, IllegalAccessException {
        Toy toy = new Toy();
        Class<?> toyClass = toy.getClass();
        Field publicField = toyClass.getDeclaredField("name");
        Field protectedField = toyClass.getDeclaredField("id");
        Field privateField = toyClass.getDeclaredField("typeToy");
        privateField.setAccessible(true);

        privateField.set(toy, "big");
        System.out.println(privateField.get(toy));
        System.out.println(publicField.getName());
        System.out.println(protectedField.getType());
    }

    //2
    @Test
    public void methodReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Toy toy = new Toy();
        Class<?> toyClass = toy.getClass();
        Method methodPrivate = toyClass.getDeclaredMethod("isrRndNumChoose");
        methodPrivate.setAccessible(true);
        System.out.println(methodPrivate.invoke(toy));

        Arrays.stream(toyClass.getDeclaredMethods()).forEach(x -> System.out.println(x.getName()));
        Arrays.stream(methodPrivate.getExceptionTypes()).forEach(x -> System.out.println(x.getSimpleName()));
    }

    //3
    @Test
    public void constructorReflection() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Toy> constructorPrivate = Toy.class.getDeclaredConstructor(String.class, int.class, String.class);
        constructorPrivate.setAccessible(true);

        Toy privateToy = constructorPrivate.newInstance("Name", 02, "big");
        System.out.println(privateToy.name);

        Constructor<Toy> publicToy = Toy.class.getDeclaredConstructor(String.class, int.class);
        System.out.println(publicToy);

        Arrays.stream(publicToy.getParameterTypes())
                .forEach(parameter -> System.out.print(parameter.getSimpleName() + " "));
    }
}
