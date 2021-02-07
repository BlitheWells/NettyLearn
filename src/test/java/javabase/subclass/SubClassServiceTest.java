package javabase.subclass;

import org.reflections.Reflections;

import java.net.URL;
import java.util.Set;

/**
 * @Author: wangzilong@111.com.cn
 * @Date: 2021/2/5 16:14
 */
public class SubClassServiceTest {

    public static void main(String[] args) {
        getSubClassTest();
        getResourceFileTest();
    }
    
    public static void getSubClassTest() {
        Reflections reflections = new Reflections("javabase.subclass");
        Set<Class<? extends BaseService>> subTypes = reflections.getSubTypesOf(BaseService.class);
        subTypes.stream().forEach(s -> System.out.println(s.getName()));
    }

    public static void getResourceFileTest() {

        URL url = SubClassServiceTest.class.getClassLoader().getResource("test/b.txt");
        System.out.println(url.getPath());

    }
}
