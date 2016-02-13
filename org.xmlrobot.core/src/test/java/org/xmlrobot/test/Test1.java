package org.xmlrobot.test;

import java.io.File;

import org.xmlrobot.core.Minkowski;
import org.xmlrobot.core.Spacetime;
import org.xmlrobot.core.Subspace;
import org.xmlrobot.core.Universe;
import org.xmlrobot.dna.Cell;
import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.dna.Genomap;
import org.xmlrobot.dna.Haploid;
import org.xmlrobot.dna.Operon;
import org.xmlrobot.dna.Ribosoma;
import org.xmlrobot.dna.Tetraploid;
import org.xmlrobot.nature.Biosphere;
import org.xmlrobot.nature.Ecosystem;
import org.xmlrobot.spacetime.AlphaCentauri;
import org.xmlrobot.spacetime.Andromeda;
import org.xmlrobot.spacetime.Columbia;
import org.xmlrobot.spacetime.Fornax;
import org.xmlrobot.spacetime.Jupiter;
import org.xmlrobot.spacetime.MilkyWay;
import org.xmlrobot.spacetime.Saturn;
import org.xmlrobot.spacetime.Sun;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;

public class Test1 {

	public Test1() {

	}

	public static void main(String[] args) {

		Universe bigBang = bigBang();

		bigBang.write(new File("./bigBang.xml"));
	}

	/**
	 * @return
	 */
	public static Universe bigBang() {
		String[] message = new String[] { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z", "Ç" };
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
		// instance dna level #1
		Genomap genomap = new Genomap(Haploid.class);
		genomap.put(cube, (Hyperchain) cube.get());
		// instance dna level #2
		Cromosoma cromosoma = new Cromosoma(Diploid.class);
		cromosoma.put(genomap, (Haploid) genomap.get());
		// instance dna level #3
		Ribosoma ribosoma = new Ribosoma(Tetraploid.class);
		ribosoma.put(cromosoma, (Diploid) cromosoma.get());
		// instance dna level #4
		Operon operon = new Operon(Cell.class);
		operon.put(ribosoma, (Tetraploid) ribosoma.get());
		// instance planetary surface
		Ecosystem ecosystem = new Ecosystem(Biosphere.class);
		ecosystem.put(operon, (Cell) operon.get());
		// instance solar system: root home
		Jupiter jupiter = new Jupiter(Saturn.class);
		jupiter.put(ecosystem, (Biosphere) ecosystem.get());
		// where we are going. Interstellar: From sun to Alpha Centauri
		Sun sun = new Sun(AlphaCentauri.class);
		sun.put(jupiter, (Saturn) jupiter.get());
		// instance galaxy domain. From Milky Way to Andromeda
		MilkyWay milkyWay = new MilkyWay(Andromeda.class);
		milkyWay.put(sun, (AlphaCentauri) sun.get());
		// instance supercluster. From fornax to columbia
		Fornax fornax = new Fornax(Columbia.class);
		fornax.put(milkyWay, (Andromeda) milkyWay.get());
		// instance minkowski spacetime
		Spacetime spacetime = new Spacetime(Minkowski.class);
		spacetime.put(fornax, (Columbia) fornax.get());
		// create universe
		Universe bigBang = new Universe(Subspace.class);
		bigBang.putValue(spacetime, (Minkowski) spacetime.get());
		return bigBang;
	}
}
