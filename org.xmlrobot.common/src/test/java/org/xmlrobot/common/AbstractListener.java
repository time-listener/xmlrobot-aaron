/**
 * 
 */
package org.xmlrobot.common;

/**
 * @author joan
 *
 */
public abstract class AbstractListener<T extends AbstractListener<T>> {

	
	/**
	 * 
	 */
	public AbstractListener() {

	}
	
	public static <V> V instance(Class<V> type){
		
		try {
			return type.newInstance();
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}
}
