import java.util.Scanner;
/*
 * class containing main method
 */
public class StackArrayImplementation {
    public static void main(String args[]) {
        int numberOfElement = 0;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        StackArrayMethods obj = new StackArrayMethods();
        while (choice != 5) {
            System.out.println("enter your choice: 1.Push  2.Pop  3.top  4.isEmpty 5.exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter no. of elements to be entered: ");
                    numberOfElement = sc.nextInt();
                    for (int i = 0; i < numberOfElement; i++)
                        obj.Push(sc.nextInt());
                    obj.show();
                    break;
                case 2:
                    obj.Pop();
                    obj.show();
                    break;
                case 3:
                    System.out.println(obj.Top());
                    break;
                case 4:
                    System.out.println(obj.isEmpty());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("incorrect choice !");
            }
        }
        sc.close();
    }
}