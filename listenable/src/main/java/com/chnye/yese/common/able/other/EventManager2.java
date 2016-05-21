package com.chnye.yese.common.able.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager2<L extends IEventListener2<E>, E extends IEvent2<ET,?>, ET extends Enum<?>> implements IEventListenable2<L,ET>{

	private Map<ET, List<L>> listenerMaps = new HashMap<ET,List<L>>();
	
	@Override
	public void addListener(ET eventType, L listener) {
		// TODO Auto-generated method stub
//		if( !listeners.contains( listener ) ){
//			listeners.add( listener );
//		}
		List<L> listeners = listenerMaps.get( eventType );
		if( listeners == null ){
			listeners = new ArrayList<L>();
		}
		if( !listeners.contains( listener ) ){
			listeners.add( listener );
		}
		listenerMaps.put( eventType, listeners );
	}

	@Override
	public void removeListener(ET eventType, L listener) {
		// TODO Auto-generated method stub
		List<L> listeners = listenerMaps.get( eventType );
		if( listeners != null && listeners.contains( listener ) ){
			listeners.remove( listener );
		}
	}
	
	/**
	 * 对外接口
	 */
	public void fireEvent( E event ){
		List<L> listeners = listenerMaps.get( event.getEventType() );
		for( L listener : listeners ){
			listener.notify( event );
		}
	}
}
