package com.chnye.yese.common.able.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chnye.yese.common.able.IListener;
import com.chnye.yese.common.able.other.EventManager;
import com.chnye.yese.common.able.other.EventManager.EventNotifyFunctor;
import com.chnye.yese.common.able.other.IEvent;
import com.chnye.yese.common.dto.PhyEqp;
import com.chnye.yese.common.dto.PhyEqpEvent;

public class TestEventLisenable {

	private static Logger logger =  LoggerFactory.getLogger( TestEventLisenable.class );
	
	private MyLogger  myLogger = null;
	private MyAsyncMessageQueue  myAsyncMessageQueue = null;
	private EventManager<IListener<IEvent<?>>, IEvent<?>>  eventManager = null;
	private EventNotifyFunctor<IListener<IEvent<?>>, IEvent<?>> functor = null;
	
	@Before
	public void init(){
		myLogger = new MyLogger();
		myAsyncMessageQueue = new MyAsyncMessageQueue();
		eventManager = new EventManager<IListener<IEvent<?>>, IEvent<?>>();
		
		functor = new EventNotifyFunctor<IListener<IEvent<?>>, IEvent<?>>() {
			@Override
			public void notify(IListener<IEvent<?>> listener, IEvent<?> event) {
				// TODO Auto-generated method stub
				logger.debug("======================begin" );
				listener.notify( event );
				logger.debug("======================end" );
			}
		};
	}
	
	@Test
	public void test(){
		
		eventManager.addListener( myLogger );
		eventManager.addListener( myAsyncMessageQueue );
		
		for( int i = 0; i < 10; i++ ){
			PhyEqp  phyEqp = new PhyEqp( i, "phy" + i, "eqp" + i );
			PhyEqpEvent event = new PhyEqpEvent( phyEqp );
//			eventManager.fireEvent( event );
			eventManager.fireEvent(functor, event);
		}
	}
}
