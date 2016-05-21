package com.chnye.yese.common.able.other;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

import com.chnye.yese.common.able.IListener;
import com.chnye.yese.common.able.other.EventManager.EventNotifyFunctor;

public class EventManager2<L extends IListener<E>, E extends IEvent2<ET, ?>, ET extends Enum<?>> implements IEventListenable2<L>{

	private ConcurrentMap<Class, Set<L>> listenerMaps = new ConcurrentHashMap<Class,Set<L>>();
	
	@Override
	public void addListener(Class<?> eventClass, L listener) {
		// TODO Auto-generated method stub
//		if( !listeners.contains( listener ) ){
//			listeners.add( listener );
//		}
//		Set<L> listeners = listenerMaps.get( eventClass );
//		if( listeners == null ){
//			listeners = new CopyOnWriteArraySet<L>();
//		}
		Set<L> listeners = nullSafeGet( eventClass );
//		if( !listeners.contains( listener ) ){
			listeners.add( listener );
//		}
//		listenerMaps.put( eventClass, listeners );
	}

	@Override
	public void removeListener(Class<?> eventClass, L listener) {
		// TODO Auto-generated method stub
//		Set<L> listeners = listenerMaps.get( eventClass );
		Set<L> listeners = nullSafeGet( eventClass );
//		if( listeners != null && listeners.contains( listener ) ){
		if( listeners.contains( listener ) ){
			listeners.remove( listener );
		}
	}

	@Override
	public void removeListener(L listener) {
		// TODO Auto-generated method stub
		for( Map.Entry<Class, Set<L>>  entry : listenerMaps.entrySet() ){
			entry.getValue().remove( listener );
		}
	}
	
	/**
	 *
	 */
	public void fireEvent( E event ){
		Set<L> listeners = listenerMaps.get( event.getClass() );
		for( L listener : listeners ){
			listener.notify( event );
		}
	}
	
	private Set<L> nullSafeGet( Class<?> eventClass ){
		Set<L> listeners = listenerMaps.get( eventClass );
		if( listeners == null ){
			listeners = new CopyOnWriteArraySet<L>();
			listenerMaps.putIfAbsent( eventClass, listeners );
		}
		return listeners;
	}

	/**
	 *  提供给外界一个机会，以其自己的方式调用
	 * @author chnye
	 *
	 * @param <L>
	 * @param <E>
	 */
	public static interface EventNotifyFunctor2<L extends IListener<E>, E>{
		void notify( L listener, E event );
	}
	
	public void fireEvent(EventNotifyFunctor2<L,E> functor, E event ){
		Set<L> listeners = listenerMaps.get( event.getClass() );
		for( L listener : listeners ){
			functor.notify( listener, event);
		}
	}
	
}
