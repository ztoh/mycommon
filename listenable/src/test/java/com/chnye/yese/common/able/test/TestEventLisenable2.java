package com.chnye.yese.common.able.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chnye.yese.common.able.IListener;
import com.chnye.yese.common.able.other.EventManager2;
import com.chnye.yese.common.able.other.EventManager2.EventNotifyFunctor2;
import com.chnye.yese.common.able.other.IEvent2;
import com.chnye.yese.common.dto.PhyEqp;
import com.chnye.yese.common.dto.PhyEqpEvent;
import com.chnye.yese.common.dto.PhyEqpEvent2;
import com.chnye.yese.common.dto.ResSpec;

public class TestEventLisenable2 {

	private static Logger logger =  LoggerFactory.getLogger( TestEventLisenable2.class );
	
	private MyLogger2  myLogger2 = null;
	private MyAsyncMessageQueue2  myAsyncMessageQueue2 = null;
	private EventManager2<IListener<IEvent2<ResSpec,?>>, IEvent2<ResSpec,?>, ResSpec>  eventManager2 = null;
	private EventNotifyFunctor2<IListener<IEvent2<ResSpec,?>>, IEvent2<ResSpec,?>> functor = null;
	
	@Before
	public void init(){
		myLogger2 = new MyLogger2();
		myAsyncMessageQueue2 = new MyAsyncMessageQueue2();
		eventManager2 = new EventManager2<IListener<IEvent2<ResSpec,?>>, IEvent2<ResSpec,?>, ResSpec>();
		
		functor = new EventNotifyFunctor2<IListener<IEvent2<ResSpec,?>>, IEvent2<ResSpec,?>>() {

			@Override
			public void notify(IListener<IEvent2<ResSpec, ?>> listener,
					IEvent2<ResSpec, ?> event) {
				// TODO Auto-generated method stub
				if( event.getEventType() == ResSpec.OBD ){
					logger.debug( "is OBD" );
					listener.notify( event );
				}
			}
		};
	}
	
	@Test
	public void test(){
		
		eventManager2.addListener( PhyEqpEvent.class, myLogger2 );
		eventManager2.addListener( PhyEqpEvent2.class, myAsyncMessageQueue2 );
		eventManager2.addListener( PhyEqpEvent2.class, myAsyncMessageQueue2 );
		
		for( int i = 0; i < 10; i++ ){
			PhyEqp  phyEqp = new PhyEqp( i, "phy" + i, "eqp" + i );
			PhyEqpEvent2 event2 = new PhyEqpEvent2(ResSpec.OBD, phyEqp);
//			eventManager2.fireEvent( event2 );
			eventManager2.fireEvent(functor, event2);
		}
	}
}
