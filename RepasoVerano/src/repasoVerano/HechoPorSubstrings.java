package repasoVerano;

import java.util.Arrays;

public class HechoPorSubstrings {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main (String[] args) {
		String s = "abababa";
		System.out.println(repeatedSubstringPattern(s));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static boolean repeatedSubstringPattern(String s) {
		for(int i = 0; i < s.length()/2; i++) {
			String aux = s.substring(0, i);
			System.out.println(aux);
			for(int j = 0; j < s.length() - aux.length(); j++) {
				System.out.println(s.substring(j, j + 1));
				if(!aux.equalsIgnoreCase(s.substring(j, j + 1))) {
					
				}
			}
		}
		return true;
	}
}
