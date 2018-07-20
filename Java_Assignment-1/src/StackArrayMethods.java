
/*
 * class containing method to operate on stack
 * such as push, pop, top, isEmpty etc.
 */
public class StackArrayMethods {
    int stackArray[] = new int[5];
    int top = -1;

    //method to insert elements in stack
    public void Push(int element) {
        if (top < 5) {
            top++;
            stackArray[top] = element;
        } else
            System.out.println("Stack overflowed !");
    }

    //method to pop element from stack
    public void Pop() {
        stackArray[top] = 0;
        top--;

    }

    //element to look topmost element in stack
    public int Top() {
        if (isEmpty())
            return 0;
        else
            return stackArray[top];
    }

    //method to check whether stack is empty or not
    public boolean isEmpty() {
        if (top != -1)
            return false;
        else
            return true;
    }

    //method to display stack elements
    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }
}