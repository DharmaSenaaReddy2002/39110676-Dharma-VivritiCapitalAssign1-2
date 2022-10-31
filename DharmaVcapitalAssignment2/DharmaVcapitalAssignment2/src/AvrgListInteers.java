import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//This code is Done by dharma
//Input of n integers and numbers will taken from console.
public class AvrgListInteers {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); //scanners class to take input from console
        int n = sc.nextInt(); //To take numbers of integers values
        List<Integer> L = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            L.add(sc.nextInt()); // to take n value of integers.
        }
        int sum = 0;
        for (int i : L) {
            sum += i;
        }
        System.out.println("The average of a List of integers : " + sum / L.size()); //calculating average of list.
    }
}