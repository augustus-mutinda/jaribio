import java.util.Stack;

public class CheckParenthesisValidity {

    static boolean areBracketsBalanced(String s) {
        Stack<Character> bracketStack = new Stack<>();

        for (char x : s.toCharArray()) {
            if ("({[".contains(String.valueOf(x)))
                bracketStack.push(x);
            else {
                if (bracketStack.isEmpty())
                    return false;
                else {
                    char opening = bracketStack.pop();
                    if ((opening == '(' && (x == '}' || x == ']'))
                            || (opening == '{' && (x == ')' || x == ']'))
                            || (opening == '[' && (x == '}' || x == ')')))
                        return false;
                }
            }
        }

        return bracketStack.isEmpty();
    }

    public static void main(String[] args) {
        String expr = "(})";

        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
