package com.chnye.yese.common.able.other;

public class AbstractEvent<T> implements IEvent<T> {

	private final T source;
	
	public AbstractEvent( T source ){
		this.source = source;
	}
	
	@Override
	public T getSource() {
		// TODO Auto-generated method stub
		return source;
	}

}
