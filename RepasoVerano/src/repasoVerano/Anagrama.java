package repasoVerano;

import java.util.Arrays;

public class Anagrama {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main (String[] args) {
		String s = "adriansanti";
		String t = "santiadrian";
		System.out.println(isAnagram(s, t));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		String[] primero = s.split("");
		String[] segundo = t.split("");
		Arrays.sort(primero);
		Arrays.sort(segundo);
		for(int i = 0; i < primero.length; i++) {
			if(!primero[i].equalsIgnoreCase(segundo[i])) {
				return false;
			}
		}
		return true;
	}
}
