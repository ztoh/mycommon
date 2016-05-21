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
	 * 
	 */
	public void fireEvent( E event ){
		for( L listener : listeners ){
			listener.notify( event );
		}
	}
	
	/**
	 *  提供给外界一个机会，以其自己的方式调用
	 * @author chnye
	 *
	 * @param <L>
	 * @param <E>
	 */
	public static interface EventNotifyFunctor<L extends IListener<E>, E>{
		void notify( L listener, E event );
	}
	
	public void fireEvent(EventNotifyFunctor<L,E> functor, E event ){
		for( L listener : listeners ){
			functor.notify( listener, event);
		}
	}
	
}
