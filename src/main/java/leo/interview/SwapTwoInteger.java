package leo.interview;

import java.lang.reflect.Field;

public class SwapTwoInteger {

    /**
     * 题目：写一个方法交换两个Integer的值
     * 考察点：对象作为方法传递时传的是对象引用的一个copy, 所以直接在方法中交换两个值并不能起到效果，
     * 或者说更改传进去的引用对象并不能改掉真正对象的值。
     * 如何解决：使用反射去修改真正对象的值。
     * */

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;

        new SwapTwoInteger().swapInteger(a, b);
        System.out.println("a:" + a + "| b: " + b);
    }

    public void swapInteger(Integer a, Integer b) {
        try {
            int aa = a.intValue();
            int bb = b.intValue();
            Class intClass = a.getClass();
            Field[] fields = intClass.getDeclaredFields();
            // 私有对象需要用 getDeclaredField
            Field valueField = intClass.getDeclaredField("value");
            // 私有对象的访问需要用 setAccessible 来设置访问权限
            valueField.setAccessible(true);
            valueField.setInt(a, bb);
            valueField.setInt(b, aa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
