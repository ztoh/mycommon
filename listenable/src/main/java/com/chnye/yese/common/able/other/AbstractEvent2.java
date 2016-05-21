package com.chnye.yese.common.able.other;

public abstract class AbstractEvent2<ET extends Enum<?>,T> extends AbstractEvent<T> implements IEvent2<ET, T>{

	private final ET eventType;
	
	public AbstractEvent2( ET eventType, T source ){
		super(source);
		this.eventType = eventType;
	}
	
	@Override
	public ET getEventType(){
		return eventType;
	}

}
