import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GenerateParenthesis {

    static boolean areBracketsBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char x : s.toCharArray()) {
            if ("({[".contains(String.valueOf(x)))
                stack.push(x);
            else {
                if (stack.isEmpty())
                    return false;
                else {
                    char opening = stack.pop();
                    if ((opening == '(' && (x == '}' || x == ']'))
                            || (opening == '{' && (x == ')' || x == ']'))
                            || (opening == '[' && (x == '}' || x == ')')))
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }

    static List<String> generateParenthesis(int n) {
        List<String> validParentheses = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, 2 * n); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 2 * n; j++) {
                if ((i & (1 << j)) != 0)
                    sb.append('(');
                else
                    sb.append(')');
            }
            if (areBracketsBalanced(sb.toString()))
                validParentheses.add(sb.toString());
        }

        return validParentheses;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
