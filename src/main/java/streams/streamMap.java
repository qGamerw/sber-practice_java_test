package streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class streamMap {
    public static void main (String[] args) {
        
        Map<String, String> map = new HashMap<>();
        map.put("first-k", "first-val");
        map.put("second-k", "second-val");
        map.put("third-k", "third-val");
        map.put("forth-k", "forth-val");
        System.out.println("Items in map");
        map.entrySet().forEach(System.out::println);

        // 1
        System.out.println("\nConverct map to list");
        List<Entry<String, String>> list = new ArrayList<>();
        list = map.entrySet().stream().collect(Collectors.toList());
        list.stream().forEach(System.out::println);

        // sw2
        System.out.println("\nConverct map to 2 lists");
        List<String> listKey = map.keySet().stream().collect(Collectors.toList());
        List<String> listValue = map.values().stream().collect(Collectors.toList());
        System.out.println("\nListKey");
        listKey.stream().forEach(System.out::println);
        System.out.println("\nListValue");
        listValue.stream().forEach(System.out::println);
    }
}
