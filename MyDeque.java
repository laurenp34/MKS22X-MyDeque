import java.io.*;
import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;


  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[]) new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[]) new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
  }
  
  public String toString(){ return ""; }
  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(E element){ return element; }
  public E removeLast(E element){  return element; }
  public E getFirst(E element){ return element;  }
  public E getLast(E element){  return element; }

  public static void main(String[] args) {
    MyDeque<String> d = new MyDeque(20);
    System.out.println(Arrays.toString(d.data));
  }

}
