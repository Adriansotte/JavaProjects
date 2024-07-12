package repasoVerano;

import java.util.Scanner;

/**
 * 
 */
public class EncuentraLaDiferencia {

	private static Scanner n;
	
	public static void main(String[] args) {
		n = new Scanner(System.in);
		String s = n.nextLine();
		String t = n.nextLine();
		System.out.println(findTheDifference(s, t));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static char findTheDifference(String s, String t) {
		for(int j = 0; j < s.length(); j++) {
			t = t.replaceFirst(s.substring(j, j + 1), "");
		}
		return t.charAt(0);
	}
}
