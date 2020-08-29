package javabase;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        // HashTable 是线程安全的，所以性能较差。

        // HashMap 是非线程安全的
        HashMap map = new HashMap();

        // 创建线程安全的 HashMap
        Map synchronizedMap = Collections.synchronizedMap(new HashMap<String, Object>());

        // HashMap 的容量大于 树化改造的最小容量时，就会进行树化改造

        // concurrentHashMap
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<String, Object>();

        Object object;

        Set set;

    }
}
