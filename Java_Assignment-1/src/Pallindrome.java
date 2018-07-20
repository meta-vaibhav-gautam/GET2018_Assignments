import java.util.Stack;
/*
 * Pallindrome class contains method to check whether
 * String is pallindrome or not
 */
public class Pallindrome {
    public boolean checkPallindrome(String str) {
        boolean flag = false;
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        String reverseString = "";
        while (!stack.isEmpty()) {
            reverseString = reverseString + (stack.pop());
        }

        if (reverseString.equals(str))
            flag = true;

        return flag;
    }
}