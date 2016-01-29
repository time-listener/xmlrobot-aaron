/**
 * 
 */
package org.xmlrobot.antimatter;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.positron.Antiproton;

/**
 * @author joan
 *
 */
@XmlRootElement
public final class Hyperdatagram 
	extends Antiproton<Character,Integer> {

	/**
	 * 8123876664920585604L
	 */
	private static final long serialVersionUID = 8123876664920585604L;

	/**
	 * @param type
	 */
	public Hyperdatagram() {
		super(Hyperdatagram.class);
	}
	/**
	 * @param type
	 * @param antitype
	 */
	public Hyperdatagram(Class<? extends Mass<Integer,Character>> antitype) {
		super(Hyperdatagram.class, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Antineutron#name()
	 */
	@Override
	public String name() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compare(Mass<Character,Integer> o1, Mass<Character,Integer> o2) {
		// typical recursive logic-safe syntax
		if (o1 != null) {

			if (o2 != null) {
				// compare values
				int cmp = Integer.compare(o1.getValue(), o2.getValue());
				// call recursion
				cmp += compare(o1.getChild(), o2.getChild());
				// return result
				return cmp;
			} else {
				return 1;
			}
		} else if (o2 != null) {
			// polarized value
			return -1;
		} else {
			// starting-finishing
			return 0;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {		
	}
}
