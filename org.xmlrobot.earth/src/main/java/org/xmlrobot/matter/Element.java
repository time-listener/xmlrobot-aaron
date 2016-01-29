package org.xmlrobot.matter;

import org.xmlrobot.Cell;
import org.xmlrobot.Operon;
import org.xmlrobot.antimatter.Hyperelement;
import org.xmlrobot.positron.Proton;

public class Element
	extends Proton<Cell,Operon> {

	/**
	 * -4054003935605395183L
	 */
	private static final long serialVersionUID = -4054003935605395183L;

	public Element() {

		super(Element.class);
	}
	public Element(Class<Hyperelement> antitype) {

		super(Element.class, antitype);
	}
}