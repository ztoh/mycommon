package com.chnye.yese.common.able.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

import com.chnye.yese.common.able.IListener;

public class EventManager2<L extends IListener<E>, E extends IEvent2<ET, ?>, ET extends Enum<?>> implements IEventListenable2<L>{

	private ConcurrentMap<Class, Set<L>> listenerMaps = new ConcurrentHashMap<Class,Set<L>>();
	
	@Override
	public void addListener(Class<?> eventClass, L listener) {
		// TODO Auto-generated method stub
//		if( !listeners.contains( listener ) ){
//			listeners.add( listener );
//		}
		Set<L> listeners = listenerMaps.get( eventClass );
		if( listeners == null ){
			listeners = new CopyOnWriteArraySet<L>();
		}
//		if( !listeners.contains( listener ) ){
			listeners.add( listener );
//		}
		listenerMaps.put( eventClass, listeners );
	}

	@Override
	public void removeListener(Class<?> eventClass, L listener) {
		// TODO Auto-generated method stub
		Set<L> listeners = listenerMaps.get( eventClass );
		if( listeners != null && listeners.contains( listener ) ){
			listeners.remove( listener );
		}
	}
	
	/**
	 * 对外接口
	 */
	public void fireEvent( E event ){
		Set<L> listeners = listenerMaps.get( event.getClass() );
		for( L listener : listeners ){
			listener.notify( event );
		}
	}
}
