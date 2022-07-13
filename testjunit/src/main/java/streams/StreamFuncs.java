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
        return set.stream()
                .filter(i -> i.length() > 10)
                .collect(Collectors.toMap(key -> key + "-key", key -> key + "-value"));
    }

    public static List<String> getListKeyAndValue(Map<String, String> map) {
        return map.entrySet()
                .stream()
                .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }

    public static List<String> getListKeyEqualValue(Map<String, String> map) {
        return map.entrySet()
                .stream()
                .map(x -> x.getKey() + " == " + x.getValue())
                .collect(Collectors.toList());
    }

    public static String getName(TestClass testClass) {
        testClass = Optional.ofNullable(testClass).orElseGet(TestClass::new);
        return testClass.getName();
    }
}
