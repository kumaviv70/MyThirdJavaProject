import java.util.ArrayList;

public class CollectionExamples {

	public static void main(String[] args) {
		ArrayList<String> alStr=new ArrayList<>();
		alStr.add("Ram");
		alStr.add("Shyam");
		alStr.add("Dhanshyam");
		alStr.add(2, "Roxy");
		System.out.println(alStr);
		alStr.set(1, "James");
		System.out.println(alStr);
		alStr.remove("Roxy");
		System.out.println(alStr);
		System.out.println(alStr.get(2));
		System.out.println(alStr.indexOf("James"));
		
		for(String str:alStr)
			System.out.println(str);
	}

}
