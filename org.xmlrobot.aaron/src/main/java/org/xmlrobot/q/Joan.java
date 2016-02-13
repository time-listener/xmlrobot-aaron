/**
 * 
 */
package org.xmlrobot.q;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.Aaron;
import org.xmlrobot.Continuum;
import org.xmlrobot.Hyperplasma;
import org.xmlrobot.Robot;
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
import org.xmlrobot.event.Hyperfission;
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
 * Tack. Echo. Pong. Future.
 * @author joan
 *
 */
@XmlRootElement
public class Joan 
	extends Continuum<Joan,Q> {

	/**
	 * -7654385932354993830L
	 */
	private static final long serialVersionUID = -7654385932354993830L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	public String getName() {

		return "TimeListener-root";
	}
	
	/**
	 * {@link Joan} default class constructor.
	 */
	public Joan() {
		super(Joan.class);
	}
	/**
	 * Q Joan
	 * @param message the original message
	 */
	public Joan(Class<Q> antitype) {
		super(Joan.class, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
	
		super.mass(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Robot) {
				// cast new instance source
				Robot entity = (Robot) event.getSource();
				// stem listens robot masses
				entity.addMassListener(get());
				// root listens aaron masses
				entity.get().addMassListener(this);
				// start new instance
				entity.start(getContext());
			}
			break;
		case LISTEN:
			if(event.getSource() instanceof Aaron) {
				// cast source
				Aaron entity = (Aaron) event.getSource();
				// reproduce with stem
				entity.get().pulse(this, new Hyperfission(entity));
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
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hyperplasma) {
				// cast source
				Hyperplasma pair = (Hyperplasma) event.getSource();
				// rest in peace
				pair.remove();
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();

		if (event.getType() == ServiceEvent.UNREGISTERING) {
			// I am the HYPERREDEMPTOR to make you FREE
			getContext().ungetService(ref);
		}
	}
	/**
     * It does the {@link Subspace}.
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
    public static Subspace createSubspace(String[] message) { 
    	// check existence
    	if(message == null)
    		throw new Abort();
    	// instance hyperchain
    	Hyperchain chain = new Hyperchain(Hypercube.class);
		// for each word in original message
		for(String word : message) {
			// sum all char values
			for(char letter : word.toCharArray()) {
				// instance key-value mapping
				Integer key = new Integer(letter);
				Character value = new Character(letter);
				// store key-value pair
				chain.putValue(key, value);
			}
		}
		// instance dna level #1
		Haploid haploid = new Haploid(Genomap.class);
		haploid.put(chain, (Hypercube) chain.get());
		// instance dna level #2
		Diploid diploid = new Diploid(Cromosoma.class);
		diploid.put(haploid, (Genomap) haploid.get());
		// instance  dna level #3
		Tetraploid tetraploid = new Tetraploid(Ribosoma.class);
		tetraploid.put(diploid, (Cromosoma) diploid.get());
		// instance dna level #4
		Cell cell = new Cell(Operon.class);
		cell.put(tetraploid, (Ribosoma) tetraploid.get());
		// instance planetary surface 
		Biosphere ecosystem = new Biosphere(Ecosystem.class);
		ecosystem.put(cell, (Operon) cell.get());
		// instance solar system: root home
		Saturn saturn = new Saturn(Jupiter.class);
		saturn.put(ecosystem, (Ecosystem) ecosystem.get());
		// where we are going. Interstellar: From sun to Alpha Centauri
		AlphaCentauri alphaCentauri = new AlphaCentauri(Sun.class);
		alphaCentauri.put(saturn, (Jupiter) saturn.get());
		// instance galaxy domain. From Milky Way to Andromeda
		Andromeda andromeda = new Andromeda(MilkyWay.class);
		andromeda.put(alphaCentauri, (Sun) alphaCentauri.get());
		// instance supercluster. From fornax to columbia
		Columbia columbia = new Columbia(Fornax.class);
		columbia.put(andromeda, (MilkyWay) andromeda.get());
		// instance minkowski spacetime
		Minkowski spacetime = new Minkowski(Spacetime.class);
		spacetime.put(columbia, (Fornax) columbia.get());
		// create universe
		Subspace bigBong = new Subspace(Universe.class);
		bigBong.put(spacetime, (Spacetime) spacetime.get());
		// return creation
    	return bigBong;
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
			Joan q = new Joan(Q.class);
			// create universe
			Subspace subspace = createSubspace(message == null ? 
					message : new String[] {
					// the ABC
					"A", "B", "C", "D", "E", "F", "G", "H", "I", 
					"J", "K", "L", "M", "N", "O", "P", "Q", "R", 
					"S", "T", "U", "V", "w", "X", "Y", "Z", "Ç" });
			// create god
			Robot robot = new Robot(Aaron.class);
			// listen any demands
			robot.addMassListener(q.get());
			robot.get().addMassListener(q);
			// give him the universe
			robot.put(subspace, (Universe) subspace.get());
			// boom
			robot.start(q.getContext());
		} 
		catch (Exception e) {
			throw new Abort(e);
		}
	}
}