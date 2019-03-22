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

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] resize = (E[]) new Object[data.length*2 + 1];
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
    data = (E[]) resize;
  }

  public void addFirst(E element){
    //first case: start+end are 0 (adding first element)
    if (start == 0 && end == 0) {
      data[0] = element;
      end++;
      size++;
      return;
    }
    //if start is 0 and there is space at the end
    else if (start == 0 && end+1 < data.length) {
      data[end+1] = element;
      end++;
      size++;
      return;
    }

    //there is space in the front, and start is before end: add to front and move start back.
    else if (start < end && start > 0) {
      data[start-1] = element;
      start --;
      size ++;
      return;
    } //there is no more space in array: resize with new element at front.
    else if (size == data.length) {
      resize(); // result of resize is start =0 and read straight
      start = end + 1; // move start to end
      data[start] = element;

    }
  }
  public void addLast(E element){ }
  public E removeFirst(E element){ return element; }
  public E removeLast(E element){  return element; }
  public E getFirst(E element){ return element;  }
  public E getLast(E element){  return element; }

  public static void main(String[] args) {
    MyDeque<Integer> d = new MyDeque<Integer>(20);
    for (int i=0;i<20;i++) {
      d.addFirst(i);
      System.out.println(Arrays.toString(d.data));
    }
    System.out.println(Arrays.toString(d.data));
    d.addFirst(-5);
    System.out.println(Arrays.toString(d.data));
  }

}
