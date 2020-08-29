package leo.interview;

public class JavaBase {

    Number number;

    public static void main(String[] args) {
        System.out.println(new JavaBase().add(1, 2));
    }

    public <T extends  Number> T add(T a, T b) {
        if (a instanceof Integer) {
            return (T) new Integer((Integer) a + (Integer) b);
        } else {
            return null;
        }
    }
}
