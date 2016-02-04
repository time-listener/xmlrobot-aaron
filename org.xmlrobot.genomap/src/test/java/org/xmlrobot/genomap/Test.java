package org.xmlrobot.genomap;

import org.xmlrobot.Gamete;
import org.xmlrobot.Gene;
import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;
import org.xmlrobot.util.Parity;

public class Test {

	public Test() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] message = new String[] { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z", "Ç" };

		Hypercube cube = new Hypercube(Hyperchain.class);
		Gene gene = new Gene(Gamete.class, cube, (Hyperchain) cube.get());
		// for each word in original message
		for (String word : message) {
			// declare counter
			int i = 0;
			// sum all char values
			for (char letter : word.toCharArray())
				i += letter;
			// instance key-value mapping
			String key = new String(word);
			Integer value = new Integer(i);
			// store key-value pair
			cube.put(key, value);
		}

//		Mass<String,Integer> child = cube.getChild();
//		cube.setChild(null);
		
//		child.setParent(null);
////		child.swap(child.getFuture());
//		child = child.permute(child.depth());
//		child.setParent(cube);
//		cube.setChild(child);
		cube.get().spin();
		cube.get().spin();
		
		cube.spin();
		cube.spin();
//		
		
//		for(Mass<String,Integer> string : cube) {
//			
//			System.out.print("\n KEY: " + string.getKey() + " VALUE: " + string.getValue() + " NAME :" + string.getName());
//		}
//		for(Mass<String,Integer> string : cube) {
//
////			if(!(string instanceof Hypercube))
//			System.out.print(string.getKey());
//		}
		System.out.print(gene);
	}
}