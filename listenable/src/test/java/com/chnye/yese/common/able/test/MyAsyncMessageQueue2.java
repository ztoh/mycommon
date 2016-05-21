package com.chnye.yese.common.able.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chnye.yese.common.able.other.IEvent;
import com.chnye.yese.common.able.other.IEvent2;
import com.chnye.yese.common.able.other.IEventListener;
import com.chnye.yese.common.able.other.IEventListener2;
import com.chnye.yese.common.dto.PhyEqp;
import com.chnye.yese.common.dto.ResSpec;

public class MyAsyncMessageQueue2 implements IEventListener2<IEvent2<ResSpec,?>>{

	private static Logger logger =  LoggerFactory.getLogger( MyAsyncMessageQueue2.class );
	

	@Override
	public void notify(IEvent2<ResSpec, ?> event) {
		// TODO Auto-generated method stub
		logger.debug( "MyAsyncMessageQueue:" + event.getSource() );
	}

}
