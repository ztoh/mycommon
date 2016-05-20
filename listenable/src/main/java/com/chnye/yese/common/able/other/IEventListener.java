package com.chnye.yese.common.able.other;

public interface IEventListener<E extends IEvent<?>> {
	void notify( E event );
}
