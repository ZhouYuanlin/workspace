import java.util.Scanner;


public class Decimal2Hex {
	private static Scanner input;

	public static void main(String[] args){
		System.out.println("Enter the decimal number:");
		input = new Scanner(System.in);
		int decimal = input.nextInt();
		System.out.println("The Hex number is "+decimalToHex(decimal));
	}
	
	public static String decimalToHex(int decimal) {
		String hexNum = "";
		while(decimal != 0){
			char hex = toHexChar(decimal % 16);
			hexNum = hex + hexNum;
			decimal = decimal / 16;
			
		}
		return hexNum;
	}
	
	public static char toHexChar(int hex){
		char hexChar;
		if(hex >= 0 && hex <= 9 )
			hexChar = (char)(hex + '0');
		else {
			hexChar = (char) (hex - 10 + 'A');
		}
		return hexChar;
	}

}
