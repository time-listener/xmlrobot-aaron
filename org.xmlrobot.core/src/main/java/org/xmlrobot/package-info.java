/**
 * 
 */
/**
 * @author joan
 *
 */
@XmlSchema(
namespace = "http://xmlrobot.org/", elementFormDefault = XmlNsForm.QUALIFIED,
	xmlns=
	{ 
		@XmlNs(prefix="hyperspace", namespaceURI="http://xmlrobot.org/"),
		@XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema")
	}
)
package org.xmlrobot;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.*;