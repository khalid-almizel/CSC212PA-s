 public interface Stack<T>{
public T pop( );
public void push(T e);
public boolean empty( );
public boolean full( );
public void multiPush(T els[], int k);
public void reverse();

Stack<T> copy();
 }
