package org.xmlrobot.genomap;

import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;
import org.xmlrobot.subspace.event.Instant;

public class Test {

	public Test() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] message = new String[] {
				"A", "B", "C", "D", "E" };
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
		String[] message2 = new String[] {
				"Z", "Y", "X", "W", "V" };
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
		Genomap map = new Genomap(Haploid.class);
		map.putValue(cube, (Hyperchain) cube.get());
		map.putValue((Hypercube) chain.get(), chain);
		
		chain.pulse(map, new Instant(cube));

//		cube.pulse(map, new Flop(chain));
//		chain.reproduceTo(cube);
		
//		System.out.print(chain.get().output());
	}
}