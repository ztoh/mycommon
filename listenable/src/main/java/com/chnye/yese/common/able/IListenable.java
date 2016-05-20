package com.chnye.yese.common.able;

public interface IListenable<L> {
	void addListener( L listener );
	void removeListener( L listener );
}
