import java.util.Scanner;

public class StackLinkedListMain {

    public static void main(String args[]) {

        stackImplementation obj = new stackImplementation();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        int numberOfElement = 0;
        while (choice != 4) {
            System.out.println("enter your choice: 1.Push  2.Pop  3.top  4.exit");
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
                    break;
                default:
                    System.out.println("incorrect choice !");
            }
        }
        sc.close();
    }
}