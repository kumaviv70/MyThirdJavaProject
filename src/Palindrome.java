
public class Palindrome {
	
	private static boolean isPalindrome(String str) {
		int i,j;
		j = str.length()-1;
		
		for(i=0; i<j; i++) {
			if(str.charAt(i) != str.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;		
	}

	public static void main(String[] args) {
		String exp="dad";
		
		if(isPalindrome(exp)) {
			System.out.println("Is a palindrome");
		} else {
			System.out.println("Is not a palindrome");
		}
	}
}
