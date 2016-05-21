package com.chnye.yese.common.able.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chnye.yese.common.able.IListener;
import com.chnye.yese.common.able.other.IEvent;
import com.chnye.yese.common.dto.PhyEqp;

public class MyAsyncMessageQueue implements IListener<IEvent<?>>{

	private static Logger logger =  LoggerFactory.getLogger( MyAsyncMessageQueue.class );
	
	@Override
	public void notify(IEvent<?> event) {
		// TODO Auto-generated method stub
		logger.debug( "MyAsyncMessageQueue:" + event.getSource() );
	}

}
