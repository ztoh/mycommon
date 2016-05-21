package com.chnye.yese.common.able.test;

import org.junit.Before;
import org.junit.Test;

import com.chnye.yese.common.able.other.EventManager;
import com.chnye.yese.common.able.other.EventManager2;
import com.chnye.yese.common.able.other.IEvent;
import com.chnye.yese.common.able.other.IEvent2;
import com.chnye.yese.common.able.other.IEventListener;
import com.chnye.yese.common.able.other.IEventListener2;
import com.chnye.yese.common.dto.PhyEqp;
import com.chnye.yese.common.dto.PhyEqpEvent;
import com.chnye.yese.common.dto.PhyEqpEvent2;
import com.chnye.yese.common.dto.ResSpec;

public class TestEventLisenable2 {

	private MyLogger2  myLogger2 = null;
	private MyAsyncMessageQueue2  myAsyncMessageQueue2 = null;
	private EventManager2<IEventListener2<IEvent2<ResSpec,?>>, IEvent2<ResSpec,?>, ResSpec>  eventManager2 = null;
	
	@Before
	public void init(){
		myLogger2 = new MyLogger2();
		myAsyncMessageQueue2 = new MyAsyncMessageQueue2();
		eventManager2 = new EventManager2<IEventListener2<IEvent2<ResSpec,?>>, IEvent2<ResSpec,?>, ResSpec>();
		
	}
	
	@Test
	public void test(){
		
		eventManager2.addListener( ResSpec.OBD, myLogger2 );
		eventManager2.addListener( ResSpec.OLT, myAsyncMessageQueue2 );
		
		for( int i = 0; i < 10; i++ ){
			PhyEqp  phyEqp = new PhyEqp( i, "phy" + i, "eqp" + i );
			PhyEqpEvent2 event2 = new PhyEqpEvent2(ResSpec.OBD, phyEqp);

			eventManager2.fireEvent( event2 );
		}
	}
}
