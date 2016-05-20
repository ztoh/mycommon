package com.chnye.yese.common.able.other;

import java.util.ArrayList;
import java.util.List;

public class EventManager<L extends IEventListener<E>, E extends IEvent<?>> implements IEventListenable<L>{

	private List<L> listeners = new ArrayList<L>();
	
	@Override
	public void addListener(L listener) {
		// TODO Auto-generated method stub
		if( !listeners.contains( listener ) ){
			listeners.add( listener );
		}
	}

	@Override
	public void removeListener(L listener) {
		// TODO Auto-generated method stub
		if( listeners.contains( listener ) ){
			listeners.remove( listener );
		}
	}
	
	/**
	 * 对外接口
	 */
	public void fireEvent( E event ){
		for( L listener : listeners ){
			listener.notify( event );
		}
	}
}
