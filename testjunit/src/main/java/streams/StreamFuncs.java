package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFuncs {

    public static double getAverage(List<Integer> list) {
        return list.stream()
                .limit(7)
                .map(x -> (x % 2 == 0) ? x + 5 : x - 5)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static Map<String, String> getMap(Set<String> set) {
        Map<String, String> map = set.stream()
                .filter(i -> i.length() > 10)
                .collect(Collectors.toMap(key -> key + "-key", key -> key + "-value"));
        return map;
    }

    public static List<String> getListkeyAndValue(HashMap<String, String> map) {
        List<String> listkeyAndValue = map
                .entrySet()
                .stream()
                .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
        return listkeyAndValue;
    }

    public static List<String> getListKeyEqualValue(HashMap<String, String> map) {
        List<String> listKeyEqualValue = map
                .entrySet()
                .stream()
                .map(x -> x.getKey() + " == " + x.getValue())
                .collect(Collectors.toList());
        return listKeyEqualValue;
    }

    public static String getName(TestClass testClass) {
        testClass = Optional.ofNullable(testClass).orElseGet(TestClass::new);
        return testClass.getName();
    }
}
