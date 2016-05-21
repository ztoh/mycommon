package com.chnye.yese.common.able.test;

import org.junit.Before;
import org.junit.Test;

import com.chnye.yese.common.able.other.EventManager;
import com.chnye.yese.common.able.other.IEvent;
import com.chnye.yese.common.able.other.IEventListener;
import com.chnye.yese.common.dto.PhyEqp;
import com.chnye.yese.common.dto.PhyEqpEvent;

public class TestEventLisenable {

	private MyLogger  myLogger = null;
	private MyAsyncMessageQueue  myAsyncMessageQueue = null;
	private EventManager<IEventListener<IEvent<?>>, IEvent<?>>  eventManager = null;
	
	@Before
	public void init(){
		myLogger = new MyLogger();
		myAsyncMessageQueue = new MyAsyncMessageQueue();
		eventManager = new EventManager<IEventListener<IEvent<?>>, IEvent<?>>();
		
	}
	
	@Test
	public void test(){
		
		eventManager.addListener( myLogger );
		eventManager.addListener( myAsyncMessageQueue );
		
		for( int i = 0; i < 10; i++ ){
			PhyEqp  phyEqp = new PhyEqp( i, "phy" + i, "eqp" + i );
			PhyEqpEvent event = new PhyEqpEvent( phyEqp );
			eventManager.fireEvent( event );
		}
	}
}
