package stacksqueues;

import java.util.LinkedList;

class BalancedStrings {

    public static void main(String[] args) {
        System.out.println(isBalanced("{{)[](}}"));
    }

    static String isBalanced(String input) {
        char[] chars = input.toCharArray();

        char[] leftBrackets = {'{', '[', '('};
        char[] rightBrackets = {'}', ']', ')'};

        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            char bracket = chars[i];
            if (includeBracket(leftBrackets, bracket)) {
                stack.push(bracket);
            } else if (includeBracket(rightBrackets, bracket)) {
                if (stack.size() == 0) {
                    return "NO";
                }
                Character left = stack.pop();
                Character right = bracket;

                int index = findIndex(leftBrackets, left);
                if (left.charValue() != leftBrackets[index] || right.charValue() != rightBrackets[index]) {
                    return "NO";
                }
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    private static int findIndex(char[] leftBrackets, Character left) {
        for (int i = 0; i < leftBrackets.length; i++) {
            if (leftBrackets[i] == left.charValue()) {
                return i;
            }
        }
        return -1;
    }

    private static boolean includeBracket(char[] brackets, char bracket) {
        for (int i = 0; i < brackets.length; i++) {
            char aChar = brackets[i];
            if (aChar == bracket) {
                return true;
            }
        }
        return false;
    }

}
