
public class Playground2
{
   
   public static void main(String[] args)
   {
      /* int barMin = 1;
      int barMax = 38;
      int cherryMin = 39;
      int cherryMax = 78;
      int spaceMin = 79;
      int spaceMax = 85;
      int sevenMin = 86;
      int sevenMax = 100;
      for (int i = 0; i < 10; i++) {
         Math.random();
         Double a = Math.random();
         Double b = Double.valueOf(a * 100);
         Integer c = b.intValue();
         if (c >= barMin && c <= barMax) {
            System.out.println("BAR");
         } else if (c >= cherryMin && c <= cherryMax) {
            System.out.println("cherries");
         } else if (c >= spaceMin && c <= spaceMax) {
            System.out.println("space");        
         } else if (c >= sevenMin && c <= sevenMax) {
            System.out.println("seven");
         } 
      }
      */
      int[] a = new int[100];
      System.out.println(a[9]);
      a[0] = 10;
      a[1] = 15;
      a[2] = a[0] + a[1];
      System.out.println(a[2]);
      Playground2[] p = new Playground2[75];
      String[] s = new String[4];
      boolean[] b = new boolean[1000];
      System.out.println(s.length);
      System.out.println(s[2]);
      System.out.println(b[999]);
      double[] myList = new double[4];
      myList[0] = 1.9;
      myList[1] = 2.9;
      myList[2] = 3.4;
      myList[3] = 3.5;
      double max = myList[0];
      for (int i = 1; i < myList.length; i++) {
         if (myList[i] > max) 
            max = myList[i];
      }
      double[] myList2 = {1.9, 2.9, 3.4, 3.5};
      for (double value: myList2)
         System.out.println(value);
      
      for (int i = 0; i < myList2.length; i++) {
         System.out.println(myList2[i]);
      }
      
      int[] values = new int[5];
      for (int i = 1; i < 5; i++) {
         values[i] = i + values[i-1];
      }
      values[0] = values[1] + values[4];
      /*
       * java.util.Scanner input = new java.util.Scanner(System.in);
       * System.out.print("Enter " + myList.length + " values: "); for (int i = 0; i <
       * myList.length; i++) { myList[i] = input.nextDouble(); }
       * System.out.print(myList);
       */
      for (int i = 0; i < myList.length; i++) {
         myList[i] = Math.random() * 100;
      }
      max = myList[0];
      for (int i = 1; i < myList.length; i++) {
         if (myList[i] > max) 
            max = myList[i];
      }
      for (int i = 0; i < myList.length; i++) {
         System.out.print(myList[i] + " ");
      }
      for (double value: myList)
         System.out.println(value);

   }

}
