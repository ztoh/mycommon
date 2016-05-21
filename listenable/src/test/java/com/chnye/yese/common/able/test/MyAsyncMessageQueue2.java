package com.chnye.yese.common.able.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chnye.yese.common.able.IListener;
import com.chnye.yese.common.able.other.IEvent2;
import com.chnye.yese.common.dto.ResSpec;

public class MyAsyncMessageQueue2 implements IListener<IEvent2<ResSpec,?>>{

	private static Logger logger =  LoggerFactory.getLogger( MyAsyncMessageQueue2.class );
	

	@Override
	public void notify(IEvent2<ResSpec, ?> event) {
		// TODO Auto-generated method stub
		logger.debug( "MyAsyncMessageQueue:" + event.getSource() );
	}

}
