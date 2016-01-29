/**
 * 
 */
package org.xmlrobot.common;

/**
 * @author joan
 *
 */
public interface IProva<K,V> {

	INested<? super K, ? super V> nested();
	
	
	public interface INested<R,S> {
		
	}
}
