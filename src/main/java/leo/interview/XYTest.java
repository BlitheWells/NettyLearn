package leo.interview;

import java.util.Scanner;

public class XYTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        if (a.equals(b)) {
            System.out.println("True");
            return;
        }
        boolean flag = false;
        for (int i = 0; i < a.length(); i ++) {
            a = a.substring(1, a.length()) + a.charAt(0);
            if (a.equals(b)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
