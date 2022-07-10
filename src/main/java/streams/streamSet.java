package streams;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamSet {
    public static void main (String[] args) {

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("c");
        treeSet.add("d");
        treeSet.add("1234567891011");
        treeSet.add("123456789101112");
        System.out.println("Elements in set:");
        treeSet.forEach( (elem) -> System.out.println(elem) );

        // 1
        System.out.println("\nLength of elements > 10:\n");
        treeSet.stream().filter(i -> i.length() > 10).forEach(System.out::println);

        // w2
        System.out.println("\nConvert filter elements to map\n");
        Stream<String> stream = treeSet.stream().filter(i -> i.length() > 10);
        Map<String, String> collect = stream.collect(Collectors.toMap(key -> key + "-key", key -> key + "-value"));
        collect.entrySet().forEach(System.out::println);
    }
}
