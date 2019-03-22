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

  private void resize() {
    Object[] resize = (E[]) new Object[data.length*2 + 1];
    int dI = start; // index for iterating through data
    int rI = 0; // index for addingto new array
    while (rI < size()) {
      resize[rI] = data[dI];
      if (rI == data.length-1) dI = 0;
      rI++;
      dI++;
    }
    start = 0;
    end = size()-1;
    data = resize;
  }

  public void addFirst(E element){
    //there is space in the front, and start is before end: add to front and move start back.
    if (start < end && start > 0) {
      data[start-1] = element;
      start --;
      size ++;
    } //there is no more space in array: resize with new element at front.
    else if (size == data.length) {
      Object[] resize = (E[]) new Object[data.length*2 + 1];

    }
  }
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
