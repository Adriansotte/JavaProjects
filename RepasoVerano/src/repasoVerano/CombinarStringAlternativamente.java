package repasoVerano;

import java.util.Scanner;

public class CombinarStringAlternativamente {
	
	private static Scanner n;
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		n = new Scanner(System.in);
		String word1 = n.nextLine();
		String word2 = n.nextLine();
		System.out.println(mergeAlternately(word1, word2));
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static String mergeAlternately(String word1, String word2) {
        String merge = "";
        for(int i = 0; i < word1.length() || i < word2.length(); i++) {
    		if(i < word1.length()) {
    			merge += word1.substring(i, i + 1);
    		}
	    	if(i < word2.length()) {
	    		merge += word2.substring(i, i + 1);
	    	}
    	}
        return merge;
    }
}
