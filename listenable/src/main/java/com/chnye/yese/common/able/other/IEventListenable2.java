package com.chnye.yese.common.able.other;



public interface IEventListenable2<L, ET>{
	void addListener( ET eventType, L listener );
	void removeListener( ET eventType, L listener );
}
