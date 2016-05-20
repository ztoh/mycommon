���пɱ�����������

�ܽ�
  1.�ṩIListenable�ķ��Ͷ���
  2.�ṩIEvent<T>�ӿڵĳ���ʵ��AbstractEvent<T>

˵��
interface IListenable<L>{
  void addListener( L listener );
  void removeListener( L listener );
}
�ýӿ��ṩ��һ�����͵Ŀɱ������������Ľӿڡ�
�Լ�������ʱû�и���Ҫ��
��ô���ڼ�������Ҫ���ǣ��������ṩһ���ӿڷ�����,���ñ�������ͳһ֪ͨ���á�
���ǰ�����֪ͨ�ݳ�Ϊ�¼�Event���������ݶ�Ϊnotify��

�¼���ĳ���ʵ��Ϊ
interface IEvent<T>{
  T getSource();
}
��ô���մ��¼���ļ���������Ϊ
interface IEventListener<E extends IEvent<?>>{
  void notify( E event );
}
�����Դ˼������ı������߶���Ϊ
interface IEventListenable<L extends IEventListener<?>> implements IListenable<L>{
}

һ����������ʵ���ඨ��Ϊ
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
    *  ����ӿ�
    */
    public void fireEvent( E event ){
      for( L listener : listeners ){
        listener.notify( event );
      }
    }
}

IEvent<T>�ӿڵĳ���ʵ����
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