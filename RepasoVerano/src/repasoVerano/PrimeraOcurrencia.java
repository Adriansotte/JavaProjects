package repasoVerano;

public class PrimeraOcurrencia {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main (String[] args) {
		String haystack = "adrianalexsanti";
		String needle = "santi";
		System.out.println(strStr(haystack, needle));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static int strStr(String haystack, String needle) {
		for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			if(haystack.substring(i, needle.length() + i).equalsIgnoreCase(needle)) {
				return i;
			}
		}
		return -1;
	}
}
