package com.chnye.yese.common.able.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chnye.yese.common.able.IListenable;
import com.chnye.yese.common.able.IListener;

public class EventManager<L extends IListener<E>, E> implements IListenable<L>{

	private List<L> listeners = new ArrayList<L>();
	
	
	@Override
	public void addListener( L listener) {
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
