package hacker_rank;

import java.util.Stack;

// 괄호 쌍 맞추기
public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(isBalanced("[]([{][][)(])}()([}[}(})}])}))]](}{}})[]({{}}))[])(}}[[{]{}]()[(][])}({]{}[[))[[}[}{(]})()){{(]]){]["));
    }

    static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                st.push(c);
            } else if (c == ']' || c == '}' || c == ')') {
                if (st.isEmpty()) {
                    return "NO";
                }
                if ((c == ']' && st.pop() != '[')
                        || (c == '}' && st.pop() != '{')
                        || (c == ')' && st.pop() != '(')) {
                    return "NO";
                }
            } else {
                return "NO";
            }
        }
        return st.isEmpty() ? "YES" : "NO";
    }
}
