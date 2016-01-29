/**
 * 
 */
package org.xmlrobot.common;

import org.xmlrobot.common.AbstractParent;

/**
 * @author joan
 *
 */
public class Child
	extends AbstractParent<Child> {

	/**
	 * 
	 */
	public Child() {

		super();
	}
	
	public Child(Class<Child> type) {
		
		super(instance(type));
	}
	
	public static void main(String[] args) {
		
//		Child child = new Child();
		
	}
}
