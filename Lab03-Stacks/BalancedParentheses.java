import java.util.Scanner;

/**
 * IT1170 - Practical 3
 * Exercise 3: Check Balanced Parentheses using Stack
 */
public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an expression with parentheses: ");
        String expression = scanner.nextLine();

        boolean isBalanced = isBalanced(expression);

        if (isBalanced) {
            System.out.println("The expression has balanced parentheses.");
        } else {
            System.out.println("The expression has imbalanced parentheses.");
        }

        scanner.close();
    }

    // Method to check balanced parentheses
    public static boolean isBalanced(String str) {
        StackArrayChar stack = new StackArrayChar(str.length());

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Helper method to check matching pairs
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }
}
