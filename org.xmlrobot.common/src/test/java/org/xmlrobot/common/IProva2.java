/**
 * 
 */
package org.xmlrobot.common;

/**
 * @author joan
 *
 */
public interface IProva2<R,S,K extends R,V extends S> extends IProva<K,V> {
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.common.IProva#nested()
	 */
	@Override
	public org.xmlrobot.common.IProva.INested<R,S> nested();
	
	public interface INested2<R,S> extends INested<R,S> {
		
	}
}