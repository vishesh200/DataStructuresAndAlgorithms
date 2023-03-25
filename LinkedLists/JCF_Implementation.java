package LinkedLists;
import java.util.LinkedList;

/* Time saving approach to implement Linked List by using Java Collection Framework
as it already has all the functionalities inbuilt in it which are well-optimised.
 */
public class JCF_Implementation {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(0);
        ll.addLast(1);
        ll.addLast(2);
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}
