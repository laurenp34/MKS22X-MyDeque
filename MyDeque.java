import java.io.*;
import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end; //start and end are inclusive.


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

  public String toString(){
    String out = "[";//System.out.println("start: "+start+"size: "+size());
    int dI = start; // index for iterating through data
    int rI = 0; // from 0 - size, to indicate when all elements have been copied.
    while (rI+1 < size()) {
      //System.out.println("I: "+dI);
      out += data[dI];
      out += ", ";
      rI++;
      dI++;
      if (dI == size()) dI = 0; // if the index is out of bounds, start from 0.
    }
    out += data[dI]; // avoid adding last comma.
    out+= "]";
    return out;
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] resize = (E[]) new Object[data.length*2 + 1];

    int dI = end;
    int rI = resize.length-1;

    while (dI >= start) {
      resize[rI] = data[dI];
      rI--;
      dI--;
    }

    end = resize.length-1;
    start = rI+1; // add one because current rI has an extra --
    data = resize;
  }

  public void addFirst(E element){
    //first case: size is 0, add to last index. update start and end.
    if (size == 0) {
      data[data.length-1] = element;
      size ++;
      start = data.length-1;
      end = data.length-1;

    }
    //if start is not 0, there is still room to add to front.
    else if (start > 0) {
      data[start-1] = element;
      size++;
      start--;
    }

    //if start reached index 0, this means that the array is full. resize
    else if (start == 0) {
      resize();
      start --;
      data[start] = element;
      size++;
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
      //d.data[i] = new Integer(4);
    }
    System.out.println(Arrays.toString(d.data));
    d.resize();
    System.out.println(Arrays.toString(d.data));
    System.out.println("start: "+d.start+"end: "+d.end);
  }

}
