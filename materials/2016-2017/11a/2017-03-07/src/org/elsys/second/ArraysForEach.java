package org.elsys.second;

public class ArraysForEach {

	public static void main(String[] args) {
		String[] words = new String[] { "hello", "world", "!", "Java" };
		String[] emptyWords = new String[5];
		
		Object[] objects = new Object[] { "1234", "world", "!" };
		
		// for each
		for (String word : words) {
			System.out.print(word + " ");
		}
	}

}
