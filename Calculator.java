public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      //first, split the string into smaller strings
      String[] split = s.split(" ");
      MyDeque<Double> nums = new MyDeque<Double>();

      double num = 0;
      int i=0; // iterate through split array.
      while (i < split.length) {
        try {
          num = Integer.parseInt(split[i]);
          nums.addLast(num);
        }catch (NumberFormatException e) {
          //reaches here if not a number.
          String cur = split[i];
          if (cur.equals("+")) {
            double n1 = nums.getLast();
            //need to remove right away so getLast() works next.
            nums.removeLast();

            double n2 = nums.getLast();
            nums.removeLast();
            //add the sum to nums
            nums.addLast(n1+n2);
          }
          else if (cur.equals("-")) {
            double n1 = nums.getLast();
            //need to remove right away so getLast() works next.
            nums.removeLast();

            double n2 = nums.getLast();
            nums.removeLast();
            //add the sum to nums
            nums.addLast(n1-n2);
          }
          else if (cur.equals("*")) {
            double n1 = nums.getLast();
            //need to remove right away so getLast() works next.
            nums.removeLast();

            double n2 = nums.getLast();
            nums.removeLast();
            //add the sum to nums
            nums.addLast(n1*n2);
          }
          else if (cur.equals("/")) {
            double n1 = nums.getLast();
            //need to remove right away so getLast() works next.
            nums.removeLast();

            double n2 = nums.getLast();
            nums.removeLast();
            //add the sum to nums
            nums.addLast((double) n1/(double) n2);
          }
          else if (cur.equals("%")) {
            double n1 = nums.getLast();
            //need to remove right away so getLast() works next.
            nums.removeLast();

            double n2 = nums.getLast();
            nums.removeLast();
            //add the sum to nums
            nums.addLast(n1%n2);
          }
        }
        i++;
      }
      return nums.getLast();

  }
  public static void main(String[] args) {
    System.out.println(eval("1 2 3 4 5 + * - -") );
  }
}
