package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class streamList {
    public static void main (String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println("Elements in list:");
        list.forEach(x -> System.out.print(x + " "));

        // 1
        System.out.println("\nDelete 3 last elements");
        list = list.stream().limit(7).collect(Collectors.toList());
        list.stream().forEach(x -> System.out.print(x + " "));

        // 2
        List<Integer> list2 = new ArrayList<>();

        list2 = list.stream().map(x -> (x % 2 == 0) ? x + 5 : x - 5).collect(Collectors.toList());
        list.clear();
        list.addAll(list2);
        System.out.println("\nModified elements");
        list.forEach(System.out::println);

        // 3
        System.out.println("\nAverage");
        list.stream().mapToInt(Integer::intValue).average().ifPresent(System.out::println);
    }
}
