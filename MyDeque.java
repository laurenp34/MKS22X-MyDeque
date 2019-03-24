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
    }

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
      size++;

    }

    //start is one after end, meaning there is no space in between. there is also
    else if (start == end+1) {
      data[start+1] = element;
      start++;
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
      //d.data[i] = new Integer(4);
    }
    System.out.println(Arrays.toString(d.data));
    d.resize();
    System.out.println(Arrays.toString(d.data));
    System.out.println("start: "+d.start+"end: "+d.end);
  }

}
