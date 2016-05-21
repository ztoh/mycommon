package com.chnye.yese.common.able.other;

import com.chnye.yese.common.able.ISource;

public interface IEvent2<ET extends Enum<?>, T> extends ISource<T>{
	ET getEventType();
}
