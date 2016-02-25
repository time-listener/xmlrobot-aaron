package org.xmlrobot.dna.matter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.dna.antimatter.Hyperintron;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.subspace.Hyperchain;
import org.xmlrobot.subspace.Hypercube;

/**
 * Intron implementation class.
 * @author joan
 * @parity XX
 * @since 1516.3
 */
@XmlRootElement
public class Intron 
	extends Positron<Hyperchain,Hypercube>{

	/**
	 * -2718890842282738451L
	 */
	private static final long serialVersionUID = -2718890842282738451L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	public String getName() {
		return getKey().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlElement
	public Hyperchain getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public Hyperchain setKey(Hyperchain key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlElement
	public Hypercube getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public Hypercube setValue(Hypercube value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Intron} default class constructor.
	 */
	public Intron() {
		super(Intron.class);
	}
	/**
	 * {@link Intron} class constructor.
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 */
	public Intron(Hyperchain key, Hypercube value) {
		super(Intron.class, key, value);
	}
	/**
	 * {@link Intron} class constructor.
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Exon} the parent
	 */
	public Intron(Hyperchain key, Hypercube value, Exon parent) {
		super(Intron.class, key, value, parent);
	}
	/**
	 * {@link Intron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 */
	public Intron(Class<Hyperintron> antitype) {
		super(Intron.class, antitype);
	}
	/**
	 * {@link Intron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 */
	public Intron(Class<Hyperintron> antitype, Hyperchain key, Hypercube value) {
		super(Intron.class, antitype, key, value);
	}
	/**
	 * {@link Intron} class constructor.
	 * @param antitype the antitype
	 * @param key {@link Hyperchain} the key
	 * @param value {@link Hypercube} the value
	 * @param parent {@link Exon} the parent
	 */
	public Intron(Class<Hyperintron> antitype, Hyperchain key, Hypercube value, Exon parent) {
		super(Intron.class, antitype, key, value, parent);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Mass<Hyperchain,Hypercube> o1, Mass<Hyperchain,Hypercube> o2) {
		return o1.getKey().compareTo(o2.getValue());
	}
}