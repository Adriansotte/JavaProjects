package repaso;

public class RecursivoIndex {

	public static void main(String[] args) {
		String n = "d";
		String n1 = "Adrian";
		System.out.println(strStr(n, n1));
		
	}
	
	public static int strStr(String n, String n1) {
		return strStr(n, n1, 0);
	}
	
	private static int strStr(String n, String n1, int i) {
		if(i == n1.length()) {
			return -1;
		} else if(n.equalsIgnoreCase(n1.substring(i, i + 1))) {
			return i;
		} else {
			return strStr(n, n1, i + 1);
		}
	}
}
