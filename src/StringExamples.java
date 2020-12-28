
public class StringExamples {

	public static void main(String[] args) {
		
		// Equals, CharAt, Contains, indexOf, substring, toLowerCase, split
		
		String str1="Selenium Automation Framework";
		String str2="Basic Java Tutorial";
		
		boolean compResult=str1.equalsIgnoreCase(str2);
		System.out.println(compResult);

		compResult=str1.contains(str2);
		System.out.println(compResult);
		
		int ind=str1.indexOf("Automation");
		System.out.println(ind);
		
		String sub=str1.substring(ind);
		System.out.println(sub);
		
		ind=str1.length();
		
		sub=str1.substring(9, ind);
		System.out.println(sub);
		
		String[] arr=str1.split("Automation");
		
		for(String str:arr)
			System.out.println("'"+str+"'");
	}

}
