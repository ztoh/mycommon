package com.chnye.yese.common.able.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chnye.yese.common.able.IListener;
import com.chnye.yese.common.able.other.IEvent;

public class MyLogger implements IListener<IEvent<?>>{

	private static Logger logger =  LoggerFactory.getLogger( MyLogger.class );

	
	@Override
	public void notify(IEvent<?> event) {
		// TODO Auto-generated method stub
		logger.debug( "MyLogger:" + event.getSource() );
	}

}
