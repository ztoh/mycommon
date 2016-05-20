package com.chnye.yese.common.able.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chnye.yese.common.able.other.IEvent;
import com.chnye.yese.common.able.other.IEventListener;
import com.chnye.yese.common.dto.PhyEqp;

public class MyLogger implements IEventListener<IEvent<PhyEqp>>{

	private static Logger logger =  LoggerFactory.getLogger( MyLogger.class );

	
	@Override
	public void notify(IEvent<PhyEqp> event) {
		// TODO Auto-generated method stub
		logger.debug( "MyLogger:" + event.getSource() );
	}

}
