package org.xmlrobot.subspace;


public class Test {

	public Test() {

	}
	public static void main(String[] args) {
		String[] message = new String[] {
				"A", "A", "A", "A" };
		
		// instance hypercube
		Hypercube cube = new Hypercube(Hyperchain.class);
		// for each word in original message
		for (String word : message) {
			// for each letter in each word in original message
			for (char letter : word.toCharArray()) {
				// instance key-value mapping
				Character key = new Character(letter);
				Integer value = new Integer((int) letter);
				// store key-value pair
				cube.put(key, value);
			}
		}
		System.out.print(cube);

		String[] message2 = new String[] {
				"B", "B", "B", "B" };
		
		// instance hypercube
		Hyperchain chain = new Hyperchain(Hypercube.class);
		// for each word in original message
		for (String word : message2) {
			// for each letter in each word in original message
			for (char letter : word.toCharArray()) {
				// instance key-value mapping
				Character value = new Character(letter);
				Integer key = new Integer((int) letter);
				// store key-value pair
				chain.put(key, value);
			}
		}
		
		chain.matrix();
		chain.reproduceTo(cube);
		
		System.out.print(chain.output());
	}
}
