package org.xmlrobot.dna.event;

import org.xmlrobot.dna.Cromosoma;
import org.xmlrobot.dna.Diploid;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Graviton;

/**
 * Mitosis is a part of the cell cycle in which chromosomes in a cell nucleus are 
 * separated into two identical sets of chromosomes, and each set ends up in its 
 * own nucleus. In general, mitosis is often accompanied or followed by cytokinesis,
 * which divides the cytoplasm, organelles and cell membrane into two new cells 
 * containing roughly equal shares of these cellular components. Mitosis and 
 * cytokinesis together define the mitotic phase of an animal cell cycle—the 
 * division of the mother cell into two daughter cells, genetically identical 
 * to each other and to their parent cell.
 * 
 * @author joan
 *
 */
public class Mitosis 
	extends Graviton<Diploid,Cromosoma> {

	/**
	 * -2289561162827937648L
	 */
	private static final long serialVersionUID = -2289561162827937648L;

	public Mitosis(Mass<Diploid,Cromosoma> source) {
		
		super(source);
	}
}
