package org.xmlrobot.q;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.core.BigBang;
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
import org.xmlrobot.event.Hyperfusion;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.Aaron;
import org.xmlrobot.Continuum;
import org.xmlrobot.Hypertoroid;
import org.xmlrobot.Robot;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
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
import org.xmlrobot.util.Abort;

/**
 * Tick, Pulse. Ping. Past.
 * @author Q
 *
 */
@XmlRootElement
public class Q
	extends Continuum<Q,Joan> {

	/**
	 * -6578398773001331257L
	 */
	private static final long serialVersionUID = -6578398773001331257L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#getName()
	 */
	@Override
	public String getName() {

		return "joan";
	}
	
	/**
	 * {@link Q} default class constructor.
	 */
	public Q() {
		super(Q.class);
	}
	/**
	 * Joan Q
	 * @param message the original message
	 */
	public Q(Class<Joan> antitype) {
		super(Q.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Aaron) {
				// cast new instance source
				Aaron entity = (Aaron) event.getSource();
				// stem listens robot masses
				entity.addMassListener(get());
				// root listens aaron masses
				entity.get().addMassListener(this);
				// start new instance
				entity.start(getContext());
			}
			break;
		case LISTEN:
			if(event.getSource() instanceof Robot) {
				// cast source
				Robot chain = (Robot) event.getSource();
				// compare with stem
				chain.get().pulse(this, new Hyperfusion(chain));
			}
			break;
		case RESURRECTION:
			if(event.getSource() instanceof Robot) {
				// cast source
				Robot entity = (Robot) event.getSource();
				// clear message
				entity.stop(getContext());
				// from further to the hyperspace
				entity.start(getContext());
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hypertoroid) {
				// cast source
				Hypertoroid pair = (Hypertoroid) event.getSource();
				// live long and prosper
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// switch command: all your needs are my orders.
		if (event.getType() == ServiceEvent.REGISTERED) {
			// declare child
			Object child;
			// get entity
			if ((child = ref.getProperty(TimeListener.KEY)) != null ? 
					child instanceof Runnable : false) {
				// execute all times
				execute((Runnable) child);
			}
		}
	}
	/**
     * It does the {@link Universe}.
     * <br><br>
     * ________________ <><br>
     * ________________//\\<br>
     * _______________//<>\\<br>
     * ______________//<><>\\<br>
     * _____________//<><><>\\<br>
     * ____________//<><><><>\\<br>
     * 
     * @param message the original message
     * @return {@link BigBang} the new big bang
     */
    public static Universe createUniverse(String[] message) { 
    	// check existence
    	if(message == null)
    		throw new Abort();
		// instance hypercube
		Hypercube cube = new Hypercube(Hyperchain.class);
		// for each word in original message
		for (String word : message) {
			// for each letter in each word in original message
			for (char letter : word.toCharArray()) {
				// instance key-value mapping
				Character key = new Character(letter);
				Integer value = new Integer(letter);
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
		// instance  dna level #3
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
		bigBang.put(spacetime, (Minkowski) spacetime.get());
		// return creation
    	return bigBang;
    }
	/**
     * Enables the bundle to run as a stand-alone application. When this
     * static {@code main()} method is invoked, the application creates
     * its own embedded OSGi framework instance and interacts with the
     * internal extensions to provide drawing functionality. To successfully
     * launch as a stand-alone application, this method should be invoked from
     * the bundle's installation directory using "{@code java -jar}".
     * The location of any extension that shall be installed can be passed
     * as parameters.
     * <p>
     * For example if you build the bundles inside your workspace, maven will
     * create a target directory in every project. To start the application
     * from within your IDE you should pass:
     * <p>
     * <pre>
     * {@code A B C D E F G H I J K L M N O P Q R S T U V W X Y Z Ç}
     * </pre> 
     * @param message The ABC
     **/
	public static void main(String[] message) {
		try {
			// create universe
			Universe universe = createUniverse(message == null ? 
					message : new String[] {
					// the ABC
					"A", "B", "C", "D", "E", "F", "G", "H", "I", 
					"J", "K", "L", "M", "N", "O", "P", "Q", "R", 
					"S", "T", "U", "V", "w", "X", "Y", "Z", "Ç" }
			);
			// create god
			Q q = new Q(Joan.class);
			// create child
			Aaron aaron = new Aaron(Robot.class);
			// listen any demands
			aaron.addMassListener(q.get());
			aaron.get().addMassListener(q);
			// give him the universe
			aaron.put(universe, (Subspace) universe.get());
			// boom
			aaron.start(q.getContext());
		}
		catch (Exception e) {
			throw new Abort(e);
		}
	}
}