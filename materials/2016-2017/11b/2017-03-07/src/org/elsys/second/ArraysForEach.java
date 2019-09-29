package org.elsys.second;

public class ArraysForEach {

	public static void main(String[] args) {
		String[] words = new String[] { "hello", "11b", "!", "this", "is", "java" };
		String[] emptyWords = new String[6];
		
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i] + " ");
		}
		System.out.println();
		// ==
		for (String word : words) {
			System.out.print(word + " ");
		}
	}

}
