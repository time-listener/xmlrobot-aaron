package org.xmlrobot.util;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.Aaron;
import org.xmlrobot.AlphaCentauri;
import org.xmlrobot.Andromeda;
import org.xmlrobot.Hyperplasma;
import org.xmlrobot.Hypertoroid;
import org.xmlrobot.Universe;
import org.xmlrobot.Subspace;
import org.xmlrobot.Biosphere;
import org.xmlrobot.Cell;
import org.xmlrobot.Columbia;
import org.xmlrobot.Continuum;
import org.xmlrobot.Cromosoma;
import org.xmlrobot.Diploid;
import org.xmlrobot.Ecosystem;
import org.xmlrobot.Fornax;
import org.xmlrobot.Genomap;
import org.xmlrobot.Haploid;
import org.xmlrobot.Jupiter;
import org.xmlrobot.MilkyWay;
import org.xmlrobot.Minkowski;
import org.xmlrobot.Operon;
import org.xmlrobot.Ribosoma;
import org.xmlrobot.Robot;
import org.xmlrobot.Saturn;
import org.xmlrobot.Spacetime;
import org.xmlrobot.Sun;
import org.xmlrobot.Tetraploid;
import org.xmlrobot.BigBang;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.Hyperchain;
import org.xmlrobot.Hypercube;

/**
 * @author Q
 *
 */
public class Q extends Continuum {

	/**
	 * 1068056844401483084L
	 */
	private static final long serialVersionUID = 1068056844401483084L;

	/**
	 * 
	 */
	public Q() {
		// send default message (27 dimensional string system)
		this(new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
						   "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
						   "U", "V", "w", "X", "Y", "Z" , "Ç"} );
	}
	/**
	 * @param message
	 */
	public Q(String[] message) {
		super();
		// create universe
		Universe universe = createBigBang(message);
		// create god
		Aaron aaron = new Aaron(Robot.class);
		// give him the universe
		aaron.put(universe, (Subspace) universe.get());
		// listen any demands
		aaron.addMassListener(this);
		// boom
		aaron.start(getContext());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case TRANSFER:
			if(event.getSource() instanceof Hyperplasma) {
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
				// rest in peace
				pair.remove();
			}
			else if(event.getSource() instanceof Hypertoroid) {
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
				// live long and prosper
				pair.remove();
			}
			break;
		case RESURRECTION:
			if(event.getSource() instanceof Aaron) {
				// cast source
				Aaron entity = (Aaron) event.getSource();
				// clear message
				entity.stop(getContext());
				// from further to the hyperspace
				entity.start(getContext());
			}
			else if(event.getSource() instanceof Robot) {
				// cast source
				Robot entity = (Robot) event.getSource();
				// clear message
				entity.stop(getContext());
				// from further to the hyperspace
				entity.start(getContext());
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
		super.serviceChanged(event);
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// declare source
		Object source;
		// get entity
		if ((source = getContext().getService(ref)) instanceof MassListener) {
			// cast source
			MassListener root = (MassListener) source;
			// switch command: all your needs are my orders.
			if(event.getType() == ServiceEvent.REGISTERED) {
				// listen everything
				root.addMassListener(this);
				// start all times
				execute(root);
			}
			if(event.getType() == ServiceEvent.UNREGISTERING) {
				// un-get current service
				getContext().ungetService(ref);
			}
		}
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
		// this is how the universe was, will be and is created.
		new Q(message);
	}
	
    /**
     * It prepares the {@link BigBang}.
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
    public static Universe createBigBang(String[] message) { 
    	// check existence
    	if(message == null)
    		throw new Abort();
    	// instance hypercube
		Hypercube cube = new Hypercube(Hyperchain.class);
		// for each word in original message
		for(String word : message) {
			// declare counter
			int i = 0;
			// sum all char values
			for(char letter : word.toCharArray())
				i += letter;
			// instance key-value mapping
			String key = new String(word);
			Integer value = new Integer(i);
			// store key-value pair
			cube.put(key, value);
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
		bigBang.putValue(spacetime, (Minkowski) spacetime.get());
		// return creation
    	return bigBang;
    }
}