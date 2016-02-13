/**
 * 
 */
/**
 * @author joan
 *
 */
@XmlSchema(
namespace = "http://xmlrobot.org/nature/", elementFormDefault = XmlNsForm.QUALIFIED,
	xmlns=
	{ 
		@XmlNs(prefix="nature", namespaceURI="http://xmlrobot.org/nature/"),
		@XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema")
	} 
) 
package org.xmlrobot.nature;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.*;