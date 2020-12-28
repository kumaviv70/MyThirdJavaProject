import java.util.Arrays;

// Question-2: Write code to sort the list of strings using Java collection?
public class SortMonths {

	public static void main(String[] args) {
		String[] month= {"Jan", "Feb", "Mar", "Apr", "May"};
		
		printArr(month);
		
		Arrays.sort(month);
		
		printArr(month);
		
		Arrays.sort(month, String.CASE_INSENSITIVE_ORDER);
		
		printArr(month);
	}
	
	public static void printArr(String[] arr) {
		for(String str:arr) {
			System.out.println(str);
		}
	}

}
