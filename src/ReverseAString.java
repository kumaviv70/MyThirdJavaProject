import java.util.Scanner;

public class ReverseAString {

	public static void main(String[] args) {
	
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter a string to reverse");
		String strToReverse = myObj.nextLine();
		System.out.println("Input string: "+strToReverse);
		myObj.close();
		
		StringBuilder strBld = new StringBuilder();
		strBld.append(strToReverse);
		System.out.println("Using string builder reverse: "+strBld.reverse());
		
		char[] chrArr = strToReverse.toCharArray();
		
		System.out.print("Using char array: ");
		for(int i=chrArr.length-1; i>=0; i--) {
			System.out.print(chrArr[i]);
		}
		
		
	}

}
