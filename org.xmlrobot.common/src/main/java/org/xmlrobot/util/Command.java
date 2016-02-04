/**
 * 
 */
package org.xmlrobot.util;

import javax.xml.bind.annotation.XmlEnumValue;
/**
 * 
 * Entity's commands.
 * <br>
 * @author joan
 *
 */
public enum Command {

	/**
	 * The entity has been instanced.
	 */
	@XmlEnumValue(value = "clone")
	CLONE,
	/**
	 * The entity has been created.
	 */
	@XmlEnumValue(value = "genesis")
	GENESIS,
	/**
	 * The entity has been created.
	 */
	@XmlEnumValue(value = "listen")
	LISTEN,
	/**
	 * The entity is listening time.
	 */
	@XmlEnumValue(value = "listening")
	LISTENING, 
	/**
	 * The entity has been interrupted.
	 */
	@XmlEnumValue(value = "interrupted")
	INTERRUPTED,
	/**
	 * The entity has reached the End of Cycle.
	 */
	@XmlEnumValue(value = "transfer")
	TRANSFER,
	/**
	 * The transmission of your message.
	 */
	@XmlEnumValue(value = "bloom")
	BLOOM,
	/**
	 * 
	 */
	@XmlEnumValue(value = "submit")
	SUBMIT,
	/**
	 * 
	 */
	@XmlEnumValue(value = "release")
	RELEASE,
	/**
	 * 
	 */
	INJECT,
	/**
	 * The natural recursive comparison.
	 */
	EXCITATION,
	/**
	 * Some message is being transmitted to the past.
	 */
	TRANSMISSION,
	/**
	 * Chromosomic aberration
	 */
	TRANSLOCATION,
	/**
	 * Something more after the End of Cycle.
	 */
	REINCARNATION,
	/**
	 * From the hyperspace to the thread pool.
	 */
	RESURRECTION,
	/**
	 * Level 5. Make the universe better.
	 */
	TRANSMUTE,
	/**
	 * Level 6. Become like me.
	 */
	TRANSCEND,
	/**
	 * Mass implementation.
	 */
	HYPERMASS,
	MARSHALLED,
	/**
	 * 
	 */
	UNMARSHALLED
}
