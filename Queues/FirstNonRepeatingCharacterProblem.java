/* We've been given a stream of characters, and we need to find after addition of each
character which is the first non-repeating character in the String and at the end we
need to print the answer */

package Queues;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterProblem {
    public static void findFirstNonRepeating(String str) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if(q.isEmpty()) {
                System.out.print(-1+" ");
            } else {
                System.out.print(q.peek()+" ");
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        findFirstNonRepeating(str);
    }
}
