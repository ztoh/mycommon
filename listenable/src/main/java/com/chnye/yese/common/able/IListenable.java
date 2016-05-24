package com.chnye.yese.common.able;

/** 
写的更紧密的版本
interface IListenable<E extends IEvent, L extends Listener<E>>{}
 */

public interface IListenable<L> {
	void addListener( L listener );
	void removeListener( L listener );
}
