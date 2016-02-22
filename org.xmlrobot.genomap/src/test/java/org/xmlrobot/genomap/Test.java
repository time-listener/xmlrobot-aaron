package org.xmlrobot.genomap;

import org.xmlrobot.dna.Gamete;
import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;

public class Test {

	public Test() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] message = new String[] {
				"H", "A", "N", "O", "C" };
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
				cube.putValue(key, value);
			}
		}
		String[] message2 = new String[] {
				"H", "O", "L", "A", "A" };
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
				chain.putValue(key, value);
			}
		}
		Genomap map = new Genomap(Haploid.class);
		map.putValue(cube, (Hyperchain) cube.get());
		map.putValue((Hypercube) chain.get(), chain);

		Gamete child = (Gamete) map.getChild().getChild().get();
		
		System.out.print(child.getPlasma().getStem());
	}
}