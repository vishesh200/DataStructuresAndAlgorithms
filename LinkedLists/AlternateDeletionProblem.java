package LinkedLists;


import java.util.LinkedList;
import java.util.Scanner;

public class AlternateDeletionProblem {
    public static void deleteNAfterM(LinkedList<Integer> list,int n, int m) {
        int count = n;
        if(n == 0) {
            System.out.println("No deletions occurred");
            return;
        }
        if(list.size() == 0) {
            System.out.println("Linked List is Empty.");
            return;
        }
        if(m == 0 && n < list.size()) {
            for(int i=0; i<n; i++) {
                list.removeFirst();
            }
            return;
        }
        if(m >= list.size() || n > list.size()) {
            System.out.println("Index Out of Bounds!");
            return;
        }

        int i = m;
        while (i < list.size()) {
            for (int j = 0; j < n && i < list.size(); j++) {
                list.remove(i);
            }
            i += m;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes to enter");
        int n = sc.nextInt();
        System.out.println("Enter the data to add: ");
        for(int i=0; i<n; i++) {
            a.addLast(sc.nextInt());
        }
        System.out.println(a);
        System.out.println("Enter N value: ");
        int N = sc.nextInt();
        System.out.println("Enter M value: ");
        int M = sc.nextInt();
        deleteNAfterM(a,N,M);
        System.out.println(a);
    }
}
