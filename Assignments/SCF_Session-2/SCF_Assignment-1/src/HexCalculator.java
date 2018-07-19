/*
 * Hexcalculator class containing methods for operation on hex numbers.
 */
public class HexCalculator implements HexCalcMethods {

    @Override
    public String add(String firstNumber, String secondNumber) // adds two hex numbers and returns hexnumber 
    {
        int sum = 0;
        int number1 = hexToDecimal(firstNumber);
        int number2 = hexToDecimal(secondNumber);
        sum = number1 + number2;

        return (decimalToHex(String.valueOf(sum)));
    }

    @Override
    public String subtract(String firstNumber, String secondNumber) // subtracts two hex numbers and returns hexnumber 
    {
        int difference = 0;
        int number1 = hexToDecimal(firstNumber);
        int number2 = hexToDecimal(secondNumber);
        difference = number1 - number2;

        return (decimalToHex(String.valueOf(difference)));
    }

    @Override
    public String multiply(String firstNumber, String secondNumber) // multiply two hex numbers and returns hexnumber 
    {
        int product = 0;
        int number1 = hexToDecimal(firstNumber);
        int number2 = hexToDecimal(secondNumber);
        product = number1 * number2;

        return (decimalToHex(String.valueOf(product)));
    }

    @Override
    public String divide(String firstNumber, String secondNumber) // divide two hex numbers and returns hexnumber 
    {
        int divideResult = 0;
        int number1 = hexToDecimal(firstNumber);
        int number2 = hexToDecimal(secondNumber);
        divideResult = number1 / number2;

        return (decimalToHex(String.valueOf(divideResult)));
    }

    @Override
    public boolean isEqual(String firstNumber, String secondNumber) //compare two hex numbers
    {
        boolean flag = false;
        if (firstNumber.compareTo(secondNumber) == 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean isGreaterThan(String firstNumber, String secondNumber) //compare two hex numbers
    {
        boolean flag = false;

        if (firstNumber.compareTo(secondNumber) > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean isLessThan(String firstNumber, String secondNumber) //compare two hex numbers
    {
        boolean flag = false;
        if (firstNumber.compareTo(secondNumber) < 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public int hexToDecimal(String number) //converts hex number to decimal
    {
        String digits = "0123456789ABCDEF";
        String hex = number;
        hex = hex.toUpperCase();
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            decimalValue = 16 * decimalValue + d;
        }
        return decimalValue;
    }

    @Override
    public String decimalToHex(String number) //convert decimal to hex number 
    {
        int remainder;
        String hex = "";
        String decimalValueString = number;
        int decimalValue = Integer.parseInt(decimalValueString);
        char hexChars[] = {
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            'A',
            'B',
            'C',
            'D',
            'E',
            'F'
        };
        while (decimalValue > 0) {
            remainder = decimalValue % 16;
            hex = hexChars[remainder] + hex;
            decimalValue = decimalValue / 16;
        }
        return hex;
    }


}