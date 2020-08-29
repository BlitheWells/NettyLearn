package leo.interview;

public class IntegerRelated {
    public static void main(String[] args) {
        System.out.println(System.getProperty("AutoBoxCacheMax"));

        // 直接用int赋值，会触发Integer 的 valueOf 方法， valueOf 方法中，作者使用了IntegerCache
        // cache 的最大值可以自己设置 java.lang.Integer.IntegerCache.high
        Integer a = 123;
        Integer b = 123;
        Integer c = new Integer(123);
        System.out.println("a == b ?:" + (a == b));
        System.out.println("a == c ?:" + (a == c));
    }
}
