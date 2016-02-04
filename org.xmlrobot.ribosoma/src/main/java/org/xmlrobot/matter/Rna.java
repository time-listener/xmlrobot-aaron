package org.xmlrobot.matter;

import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.antimatter.Hyperrna;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

/**
 * @author joan
 *
 */
public class Rna extends Neutron<Diploid,Cromosoma>{

	/**
	 * -5814223426684491592L
	 */
	private static final long serialVersionUID = -5814223426684491592L;

	/**
	 * @param key
	 * @param value
	 */
	public Rna(Diploid key, Cromosoma value) {
		
		super(Rna.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Rna(Diploid key, Cromosoma value, Dna parent) {
		
		super(Rna.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Rna(Class<Hyperrna> antitype, Diploid key, Cromosoma value) {
		
		super(Rna.class, antitype, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 * @param parent
	 */
	public Rna(Class<Hyperrna> antitype, Diploid key, Cromosoma value, Dna parent) {
		
		super(Rna.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	public String getName() {

		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Diploid,Cromosoma> o1, Mass<Diploid,Cromosoma> o2) {
		
		return o1.getKey().compareTo(o2.getValue());
	}

}
