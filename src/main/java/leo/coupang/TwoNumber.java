package leo.coupang;

import java.util.LinkedList;
import java.util.List;

public class TwoNumber {

    public static void main(String[] args) {
        TwoNumber tn = new TwoNumber();
        LinkedList<Integer> a = new LinkedList();//
        a.add(1);
        LinkedList<Integer> b = new LinkedList();
        b.add(5);
        b.add(6);
        b.add(4);

        LinkedList list = tn.add(a, b);

        tn.printList(list);

        LinkedList<Integer> a1 = new LinkedList();//
        a1.add(9);
        a1.add(9);
        LinkedList<Integer> b1 = new LinkedList();
        b1.add(9);
        b1.add(9);
        b1.add(9);

        LinkedList list1 = new TwoNumber().add(b1, a1);

        tn.printList(list1);


        System.out.println("END");
    }

    public String printAList(List<String> list) {
        return null;
    }

    public void printList(List list) {
        list.stream().forEach(e -> System.out.print(e + " -> "));
        System.out.println();
    }

    public LinkedList<Integer> add(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = 0;
        int high = 0;
        while (i < a.size() || i < b.size()) {
            int sum = 0;
            if (i >= a.size()) {
                sum =  b.get(i) + high;
            } else if (i >= b.size()) {
                sum = a.get(i) +  high;
            } else {
                sum = a.get(i) + b.get(i) + high;
            }
            res.add(sum % 10);
            high = sum / 10;
            i ++;
        }
        if (high != 0) {
            res.add(high);
        }
        return res;
    }
}
