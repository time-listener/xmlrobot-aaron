/**
 * 
 */
/**
 * @author joan
 *
 */
@XmlSchema(
namespace = "http://xmlrobot.org/hyperclock/hypermap", elementFormDefault = XmlNsForm.QUALIFIED,
	xmlns=
	{ 
		@XmlNs(prefix="hypermap", namespaceURI="http://xmlrobot.org/hyperclock/hypermap"),
		@XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema")
	} 
) 
package org.xmlrobot;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.*;