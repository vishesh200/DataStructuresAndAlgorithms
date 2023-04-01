package Stacks;

import java.util.Stack;

public class SimplifyPathProblem {
    public static String simplifyPath(String absPath) {
        Stack<String> s = new Stack<>();
        String[] dirs = absPath.split("/");
        for(String dir : dirs) {
            if(dir.equals(".") || dir.isEmpty()) {
                continue;
            } else if (dir.equals("..")) {
                if(!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(dir);
            }
        }
        if (s.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for(String dir : s) {
            sb.append("/");
            sb.append(dir);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String absPath = "/home/./user/../dir";
        String res = simplifyPath(absPath);
        System.out.println(res);
    }
}
