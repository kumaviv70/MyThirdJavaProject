
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Sortsentence {

	public static void main(String[] args) {
		String str = "I should have answered this question";

		String[] strArr = str.split(" ");
		String temp="";

		for (int i = 0, k=0; k < strArr.length; k++) {
			for (int j = 1; j < strArr.length; j++) {
				System.out.println("strArr[" + i + "]" + strArr[i]);
				System.out.println("strArr[" + j + "]" + strArr[j]);
				if (strArr[i].length() > strArr[j].length()) {
					temp=strArr[j];
					strArr[j] = strArr[i];
					strArr[i]=temp;
				}
				i++;
			}
			i=0;
		}
		for(String strSorted:strArr) {
			System.out.println("Sorted : "+strSorted);
		}
		
		sortOtherWay(strArr);
	}
	
	public static void sortOtherWay(String[] strAr) {
		HashMap<Integer, String> hMap  = new HashMap<>();
		TreeMap<Integer, String> tMap = new TreeMap<>();
		
		for(String str:strAr) {
			hMap.put(str.length(), str);
		}
		
		tMap.putAll(hMap);
		
		for(Map.Entry<Integer, String> entry:tMap.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());		
		}
	
	}
}
