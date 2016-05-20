具有可被监听的能力

总结
  1.提供IListenable的泛型定义
  2.提供IEvent<T>接口的抽象实现AbstractEvent<T>

说明
interface IListenable<L>{
  void addListener( L listener );
  void removeListener( L listener );
}
该接口提供了一个泛型的可被监听的能力的接口。
对监听器暂时没有给出要求。
那么对于监听器的要求是，它必须提供一个接口方法名,好让被监听者统一通知调用。
我们把这种通知暂称为事件Event。方法名暂定为notify。

事件类的抽象实现为
interface IEvent<T>{
  T getSource();
}
那么接收此事件类的监听器定义为
interface IEventListener<E extends IEvent<?>>{
  void notify( E event );
}
最后针对此监听器的被监听者定义为
interface IEventListenable<L extends IEventListener<?>> implements IListenable<L>{
}

一个被监听者实现类定义为
class EventManager<L extends IEventListener<E>, E extends IEvent<?>> implements IEventListenable<L>{
    private List<L> listeners = new ArrayList<L>();
    
    @Override
    public void addListener( L listener ){
      if( !listeners.contains( listener ) ){
        listeners.add( listener );
      }
    }
    
    @Override
    public void removeListener( L listener ){
      if( listeners.contain( listener ) ){
        listeners.remove( listener );
      }
    }
    
    /**
    *  对外接口
    */
    public void fireEvent( E event ){
      for( L listener : listeners ){
        listener.notify( event );
      }
    }
}

IEvent<T>接口的抽象实现类
class abstract class AbstractEvent<T> implements IEvent<T>{
  private final T source;
  
  public AbstractEvent( T source ){
  	this.source = source;
  }
  
  @Override
  public T getSource(){
  	return source;
  }
}