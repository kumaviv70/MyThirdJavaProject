
public class JavaConstructs {

	public static void main(String[] args) {
	
		// IF
		int x=5;
		if(x==5) {
			System.out.println("x=5");
		} else if(x==4) {
			System.out.println("x=4");
		} else {
			System.out.println("X is not 5 or 4");
		}
		
		// SWITCH
		switch (x) {
		case 5: System.out.println("x=5");
				break;
		case 4: System.out.println("x=4");
				break;
		default: System.out.println("Not 5 or 4");		
		}
		
		for(int i=0; i<=5; ++i) {
			printNum(x);
		}	
		System.out.println(sumNum(3));	
	}
	
	static void printNum(int x) {
		System.out.println(x);
	}
	
	static int sumNum(int x) {
		return 5+x;
	}
}
