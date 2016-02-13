package org.xmlrobot.genomap;
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
				cube.put(key, value);
			}
		}
		
//		cube.setGen(Parity.YY);
//		cube.get().setGen(Parity.YY);
//		cube.spin();
//		cube.get().spin();
//		cube.setGen(Parity.XY);
//		cube.get().setGen(Parity.XX);
		
		System.out.print(cube);

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
				chain.put(key, value);
			}
		}
		
//		chain.setGen(Parity.YY);
//		chain.get().setGen(Parity.YY);
//		chain.spin();
//		chain.get().spin();
//		chain.setGen(Parity.XY);
//		chain.get().setGen(Parity.XX);
		
		
		Genomap genomap = new Genomap(Haploid.class);
		genomap.put(cube, (Hyperchain) cube.get());
		genomap.put((Hypercube) chain.get(), chain);
		
		

		System.out.print("\n" + genomap.depth());
		
//		genomap.reproduceTo(genomap.get());
//		
//		System.out.print("\n" + genomap.output());
		
//		cube.reproduceTo(chain);
//		chain.reproduceTo(cube);
//		
//		System.out.print(cube.output());
//		System.out.print("\n" + chain.output());
	}
}