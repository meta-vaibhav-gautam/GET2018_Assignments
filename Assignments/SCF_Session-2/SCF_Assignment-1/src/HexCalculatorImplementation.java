import java.util.Scanner;
/*
 * class contains main() method
 */
public class HexCalculatorImplementation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String firstNumber = "";
        String secondNumber = "";
        String data = "";
        System.out.println("Enter you choice:");
        System.out.println("1.Add  2.Subtract  3.Multiply  4.Divide  5.check equals " +
            " 6.check greater than  7.check less than  8.convert into Decimal  " +
            "9.conver into hex");
        int menuChoice = sc.nextInt();
        if (menuChoice >= 1 && menuChoice <= 7) {
            System.out.println("Enter the First Number: ");
            firstNumber = sc.next();
            System.out.println("Enter the Second Number: ");
            secondNumber = sc.next();

        } else {
            System.out.println("Enter the data: ");
            data = sc.next();

        }
        HexCalculator obj = new HexCalculator(); //object declaration of HexCalcultor class
        switch (menuChoice) {

            case 1:
                System.out.println("Sum = " + obj.add(firstNumber, secondNumber));
                break;
            case 2:
                System.out.println("Difference = " + obj.subtract(firstNumber, secondNumber));
                break;
            case 3:
                System.out.println("Product " + obj.multiply(firstNumber, secondNumber));
                break;
            case 4:
                System.out.println("Divison = " + obj.divide(firstNumber, secondNumber));
                break;
            case 5:
                System.out.println(obj.isEqual(firstNumber, secondNumber));
                break;
            case 6:
                System.out.println(obj.isGreaterThan(firstNumber, secondNumber));
                break;
            case 7:
                System.out.println(obj.isLessThan(firstNumber, secondNumber));
                break;
            case 8:
                System.out.println(obj.hexToDecimal(data));
                break;
            case 9:
                System.out.println(obj.decimalToHex(data));
                break;
            default:
                System.out.println("Invalid input !");
        }
        sc.close();
    }

}