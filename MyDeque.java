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
    String out = "{";//System.out.println("start: "+start+"size: "+size());
    int dI = start;
    while (dI != end) {
      out+= data[dI]+" ";
      dI++;
      if (dI == data.length) dI=0;
    }
    //at this point, dI == end
    out += data[dI];
    out+= "}";
    return out;
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] resize = (E[]) new Object[data.length*2 + 1];

    int dI = end;
    int rI = resize.length-1;

    while (dI != start) {

      resize[rI] = data[dI];
      rI--;
      dI--;
      if (dI == -1) dI = data.length-1;
    }
    //dI = start here, last time to copy data over
    resize[rI] = data[dI];

    end = resize.length-1;
    start = rI-1; // add one because current rI has an extra --
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
    //if start reached index 0 and the array is full, resize
    else if (size() == data.length) {
      resize();
      start --;
      data[start] = element;
      size++;
    }
    //if start is not 0, there is still room to add to front.
    else if (start > 0) {
      data[start-1] = element;
      size++;
      start--;
    }

    //since passed prev test(array is not full), if start is 0 this means there's still space after end.
    // move new element to last spqce in array
    else if (start == 0) {
      data[data.length-1] = element;
      start = data.length-1;
      size++;
    }
  }


  public void addLast(E element){
    //if this is the first element ever, add to last index and init start and end.
    if (size() == 0) {
      data[data.length-1] = element;
      start = data.length-1;
      end = data.length-1;
      size++;

    }
    //if array is full, resize and add new element to first index.
    else if (size() == data.length) {
      resize();
      data[0] = element;
      end = 0;
      size++;
    }
    //if end is not at the last index of data (you can add to end+1)
    else if (end != data.length-1) {
      data[end+1] = element;
      end++;
      size++;
    }
    //else: if end is at last index but there is space in front.
    else {
      data[0] = element;
      end = 0;
      size++;
    }
  }

  public E removeFirst(){
    E temp = data[start];
    data[start] = null;
    if (start == data.length-1) start = 0;
    else start++;
    size--;
    return temp;
  }

  public E removeLast(){
    E temp = data[end];
    data[end] = null;
    if (end == 0) end = data.length-1;
    else end --;
    size--;
    return temp;
  }
  public E getFirst(E element){ return element;  }
  public E getLast(E element){  return element; }

  public static void main(String[] args) {
    MyDeque<Integer> d = new MyDeque<Integer>(20);
    for (int i=0;i<20;i++) {
      if (i<10) d.addFirst(i);
      else d.addLast(i);
      //d.data[i] = new Integer(4);
    }
    System.out.println(d);
    d.removeFirst();
    d.removeLast();
    System.out.println(d);
  }

}
