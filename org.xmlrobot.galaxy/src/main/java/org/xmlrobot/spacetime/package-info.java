/**
 * 
 */
/**
 * @author joan
 *
 */
@XmlSchema(
namespace = "http://xmlrobot.org/spacetime/", elementFormDefault = XmlNsForm.QUALIFIED,
	xmlns=
	{ 
		@XmlNs(prefix="spacetime", namespaceURI="http://xmlrobot.org/spacetime/"),
		@XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema")
	}
)
package org.xmlrobot.spacetime;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.*;