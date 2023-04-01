package Stacks;
import java.util.Stack;

/*
Here we need to verify if the given expression is valid or not and a valid
expression has equal number opening and closing parentheses,curly brackets or
square brackets and their order is also correct.
Ex of Valid Parentheses : '((){}[])', '[{}]([{}])'
 */

public class ValidParentheses {

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                s.push(c);
            }
            else {
                if(s.isEmpty()) {
                    return false;
                }
                if((c == ')' && s.peek() == '(') ||
                   (c == '}' && s.peek() == '{') ||
                   (c == ']' && s.peek() == '[')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "({})[]";
        System.out.println(isValid(str));
    }
}
