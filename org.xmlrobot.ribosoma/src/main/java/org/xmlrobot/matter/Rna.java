package org.xmlrobot.matter;

import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.antimatter.Hyperrna;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

public class Rna extends Neutron<Diploid,Cromosoma>{

	/**
	 * -5814223426684491592L
	 */
	private static final long serialVersionUID = -5814223426684491592L;

	public Rna(Diploid key, Cromosoma value) {
		
		super(Rna.class, key, value);
	}
	public Rna(Class<Hyperrna> antitype, Diploid key, Cromosoma value) {
		
		super(Rna.class, antitype, key, value);
	}
	@Override
	public String name() {

		return getKey().name();
	}
	@Override
	public int compare(Mass<Diploid,Cromosoma> o1, Mass<Diploid,Cromosoma> o2) {
		
		return o1.getKey().compareTo(o2.getValue());
	}

}
