package javabase;

public class QuickSortTest {

    public static void main(String[] args) {
        printArray(quickSort(new int[]{7, 6, 5, 4, 3, 2, 1}));
    }

    public static int[] quickSort(int[] numbs) {
        if(numbs.length <= 1) {
            return numbs;
        }

        int i = 0, j = numbs.length - 1;
        int flag = numbs[0];
        int flagIndex = 0;
        while(true) {
            while(numbs[j] > flag && i < j) {
                j --;
            }
            while(numbs[i] <= flag && i < j) {
                i ++;
            }
            if (i == j) {
                flagIndex = i;
                numbs[0] = numbs[i];
                numbs[i] = flag;
                break;
            } else {
                int temp = numbs[j];
                numbs[j] = numbs[i];
                numbs[i] = temp;
                j --;
            }
        }
        printArray(numbs);
        int[] left = quickSort(subArray(numbs, 0, flagIndex));
        int[] right = quickSort(subArray(numbs, flagIndex + 1, numbs.length));
        int mid = flag;
        return combine(left, mid, right);
    }

    public static void printArray(int[] numbs) {
        for (int i = 0; i < numbs.length; i ++) {
            System.out.print(numbs[i] + " ");
        }
        System.out.println();
    }

    public static int[] combine(int[] head, int mid, int[] tail) {
        int[] newArray = new int[head.length + 1 + tail.length];
        int index = 0;
        for (int i = 0; i < head.length; i ++) {
            newArray[index] = head[i];
            index ++;
        }
        newArray[index] = mid;
        index ++;
        for (int i = 0; i < tail.length; i ++) {
            newArray[index] = tail[i];
            index ++;
        }
        return  newArray;
    }

    public static int[] subArray(int[] numbs, int start, int end) {
        if (start >= end || start < 0 || start > numbs.length - 1 || end > numbs.length) {
            return new int[]{};
        }
        int[] newArray = new int[end - start];
        for(int i = 0; i < newArray.length; i ++) {
            newArray[i] = numbs[start];
            start ++;
        }
        return newArray;
    }

}
