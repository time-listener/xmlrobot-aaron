/**
 * 
 */
/**
 * @author joan
 *
 */
@XmlSchema(
namespace = "http://xmlrobot.org/matter/", elementFormDefault = XmlNsForm.QUALIFIED,
	xmlns=
	{ 
		@XmlNs(prefix="matter", namespaceURI="http://xmlrobot.org/matter/"),
		@XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema")
	}
)
package org.xmlrobot.dna.matter;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.*;