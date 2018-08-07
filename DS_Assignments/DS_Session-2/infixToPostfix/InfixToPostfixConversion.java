package infixToPostfix;

import java.util.StringTokenizer;

/*
 * class containing method to convert an infix expression to postfix
 * created on August 03, 2018
 */
public class InfixToPostfixConversion {

    private String postfixExpression = "";
    String stackForPostfix[];
    int top = -1;
    /*
     * method to convert infix expression to postfix expression
     * @param infix expression as string input
     * @return postfixExpression as String value
     */
    public String convertInfixToPostfix(String infixExpression) {

        stackForPostfix = new String[infixExpression.length()];
        StringTokenizer tokens = new StringTokenizer(infixExpression);
        while (tokens.hasMoreTokens()) {
            try {

                String element = tokens.nextToken();

                if (getPriority(element) == 0) {
                    postfixExpression += element;
                    postfixExpression += " ";
                } else {

                    if (top == -1 || "(".equals(stackForPostfix[top])) {
                        push(element);

                    } else {

                        if (getPriority(stackForPostfix[top]) < getPriority(element) && (!(")".equals(element)))) {
                            push(element);

                        } else {

                            if (")".equals(element)) {
                                String poppedElement = pop();
                                while (!("(".equals(poppedElement))) {

                                    if (!("(".equals(poppedElement) || ")".equals(poppedElement))) {
                                        postfixExpression += poppedElement;
                                        postfixExpression += " ";
                                        poppedElement = pop();
                                    }
                                }
                            } else {

                                while (top != -1 && (getPriority(stackForPostfix[top]) >= getPriority(element) && (!stackForPostfix[top].equals("(")))) {
                                    String poppedElement = pop();
                                    if (!("(".equals(poppedElement) || ")".equals(poppedElement))) {
                                        postfixExpression += poppedElement;
                                        postfixExpression += " ";
                                    }
                                }
                                if (!("(".equals(element) || ")".equals(element))) {
                                    push(element);
                                }

                            }
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid expression entered !");
            }
        }
        while (top != -1) {
            String poppedElement = pop();
            if (!("(".equals(poppedElement) || ")".equals(poppedElement))) {
                postfixExpression += poppedElement;
                postfixExpression += " ";
            }
        }

        return postfixExpression;
    }

    /*
     * method to push element to stack
     * @param operand as String value
     */
    private void push(String element) {
        stackForPostfix[++top] = element;
    }

    /*
     * method to pop element from stack
     * @return operand as String
     */
    private String pop() {
        if (top == -1) {
            return "";
        }
        String element = stackForPostfix[top];
        top--;
        return element;
    }

    /*
     * method to get the priority of the operator
     * @param operator as character input
     * @return priority of the operator 
     */
    private int getPriority(String operator) {
        if ("||".equals(operator))
            return 3;
        if ("&&".equals(operator))
            return 4;
        if ("^".equals(operator))
            return 14;
        if ("==".equals(operator) || "!=".equals(operator))
            return 8;
        if ("<".equals(operator) || "<".equals(operator) || ">=".equals(operator) || "<=".equals(operator))
            return 9;
        if ("+".equals(operator) || "-".equals(operator))
            return 11;
        if ("*".equals(operator) || "/".equals(operator))
            return 12;
        if ("!".equals(operator))
            return 13;
        if ("(".equals(operator) || ")".equals(operator))
            return 15;

        return 0;
    }

}