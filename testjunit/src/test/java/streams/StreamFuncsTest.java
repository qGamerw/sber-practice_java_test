package streams;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StreamFuncsTest {
    @Test
    public void getAverageTest() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list2 = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> list3 = List.of(0, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(3.2, StreamFuncs.getAverage(list), 0.1);
        assertEquals(3.7, StreamFuncs.getAverage(list2), 0.1);
        assertEquals(2.8, StreamFuncs.getAverage(list3), 0.1);
    }

    @Test
    public void getMapTest() {
        Set<String> set = Set.of(
                "a",
                "b",
                "c",
                "d",
                "we",
                "1234567891011",
                "123456789101112"
        );
        assertEquals(
                "{1234567891011-key=1234567891011-value, 123456789101112-key=123456789101112-value}",
                StreamFuncs.getMap(set).toString()
        );
        assertEquals("1234567891011-value", StreamFuncs.getMap(set).get("1234567891011-key"));
        assertNull(StreamFuncs.getMap(set).get("asd"));
    }

    @Test
    public void getKeyDoubleEqualValueTest() {
        HashMap<String, String> map = new HashMap<>();
        map.put("first-k", "first-val");
        map.put("second-k", "second-val");
        map.put("third-k", "third-val");
        map.put("forth-k", "forth-val");
        assertEquals(4, StreamFuncs.getListKeyEqualValue(map).size());
        assertTrue(StreamFuncs.getListKeyEqualValue(map).contains("first-k == first-val"));
        assertTrue(StreamFuncs.getListKeyEqualValue(map).contains("forth-k == forth-val"));
    }

    @Test
    public void getListKeyAndValueTest() {
        HashMap<String, String> map = new HashMap<>();
        map.put("first-k", "first-val");
        map.put("second-k", "second-val");
        map.put("third-k", "third-val");
        map.put("forth-k", "forth-val");
        assertEquals(8, StreamFuncs.getListkeyAndValue(map).size());
        assertTrue(StreamFuncs.getListKeyAndValue(map).contains("first-k"));
        assertTrue(StreamFuncs.getListKeyAndValue(map).contains("first-val"));
    }

    @Test
    public void getNameTest() {
        TestClass testClass = null;
        assertEquals("", StreamFuncs.getName(testClass));
        testClass = new TestClass();
        testClass.setName("Egor");
        assertEquals("Egor", StreamFuncs.getName(testClass));
    }
}
