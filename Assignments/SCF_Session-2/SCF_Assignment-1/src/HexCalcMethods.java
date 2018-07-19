
public interface HexCalcMethods {

	public String add(String firstNumber, String secondNumber);
	public String subtract(String firstNumber, String secondNumber);
	public String multiply(String firstNumber, String secondNumber);
	public String divide(String firstNumber, String secondNumber);
	public boolean isEqual(String firstNumber, String secondNumber);
	public boolean isGreaterThan(String firstNumber, String secondNumber);
	public boolean isLessThan(String firstNumber, String secondNumber);
	public int hexToDecimal(String number);
	public String decimalToHex(String number);
}
