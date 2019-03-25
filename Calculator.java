public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      //first, split the string into smaller strings
      String[] split = s.split(" ");
      MyDeque<Integer> nums = new MyDeque<Integer>();

      int num = 0;
      int i=0; // iterate through split array.
      while (i < split.length) {
        try {
          num = Integer.parseInt(split[i]);
          nums.addLast(num);
        }catch (NumberFormatException e) {
          //reaches here if not a number.
          String cur = split[i];
          if (cur.equals("+")) {
            int n1 = nums.getLast();
            //need to remove right away so getLast() works next.
            nums.removeLast();

            int n2 = nums.getLast();
            nums.removeLast();
            //add the sum to nums
            nums.addLast(n1+n2);
          }
        }
        i++;
      }
      return nums.getLast();

  }
  public static void main(String[] args) {
    System.out.println(eval("2 3 +"));
  }
}
