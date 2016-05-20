package com.chnye.yese.common.dto;

import com.chnye.yese.common.able.other.IEvent;

public class PhyEqpEvent implements IEvent<PhyEqp>{

	public PhyEqp source;
	

	@Override
	public PhyEqp getSource() {
		// TODO Auto-generated method stub
		return source;
	}

}
