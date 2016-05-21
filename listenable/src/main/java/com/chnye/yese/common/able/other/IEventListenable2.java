package com.chnye.yese.common.able.other;



public interface IEventListenable2<L>{
	void addListener( Class<?> eventClass, L listener );
	void removeListener( Class<?> eventClass, L listener );
}
