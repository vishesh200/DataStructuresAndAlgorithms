package Stacks;
import java.util.Stack;

/*
We have been given an expression with valid parentheses and we need to create
a method which returns true if there exists duplicate parentheses in the expression
and false otherwise. Duplicate parentheses are the ones which surround an expression
which already has a parenthesis surrounding it.
Ex: ((a+b)), ((a+b) + ((b)))
*/

/* We count the number of operands and operators existing between a pair of parenthesis
and pop them simultaneously from the given expression and if that number is zero then
we return true as that pair doesn't enclose any valid expression so it is unnecessary
and hence duplicate.
 */

public class DuplicateParentheses {

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') {
                int count = 0;
                while(s.pop() != '(') {
                    count++;
                }
                if(count < 1) {
                    return true;
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(isDuplicate(str));
    }
}
