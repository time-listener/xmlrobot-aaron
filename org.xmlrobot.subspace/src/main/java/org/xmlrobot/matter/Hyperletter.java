package org.xmlrobot.matter;

import org.xmlrobot.antimatter.Hyperline;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Neutron;

/**
 * @author joan
 *
 */
public class Hyperletter 
	extends Neutron<Integer,String>{

	/**
	 * -3417172843256231611L
	 */
	private static final long serialVersionUID = -3417172843256231611L;

	public Hyperletter() {
		super();
	}
	/**
	 * @param key
	 * @param value
	 */
	public Hyperletter(Integer key, String value) {
		super(Hyperletter.class, key, value);
	}
	/**
	 * @param key
	 * @param value
	 */
	public Hyperletter(Integer key, String value, Hyperword parent) {
		super(Hyperletter.class, key, value, parent);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hyperletter(Class<Hyperline> antitype, Integer key, String value) {
		super(Hyperletter.class, antitype, key, value);
	}
	/**
	 * @param antitype
	 * @param key
	 * @param value
	 */
	public Hyperletter(Class<Hyperline> antitype, Integer key, String value, Hyperword parent) {
		super(Hyperletter.class, antitype, key, value, parent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#name()
	 */
	@Override
	public String getName() {
		
		return !isEmpty() ? concat(new String()) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Electron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Integer,String> o1, Mass<Integer,String> o2) {

		return o1.getValue().compareTo(o2.getValue());
	}
    /**
     * @param str
     * @return
     */
    public String concat(String str) {
    	
        if (getValue() == null) {
            return str;
        }
        // concatenate string
        str.concat(getValue().toString());
        // get the child
        Mass<Integer,String> child = getChild();
        // return string or call recursion
        return child != null ?
        		child instanceof Hyperletter ?
        				((Hyperletter) child).concat(str) 
        				: str
        		: str;
    }
}