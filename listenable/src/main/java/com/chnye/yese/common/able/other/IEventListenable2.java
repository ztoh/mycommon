package com.chnye.yese.common.able.other;



public interface IEventListenable2<L extends IEventListener2<?>, ET extends Enum<?>>{
	void addListener( ET eventType, L listener );
	void removeListener( ET eventType, L listener );
}
