import java.math.BigInteger;

public class Playground
{

   public static void main(String[] args)
   {
      // TODO Auto-generated method stub
      Double doubleObject = Double.valueOf("12.4");
      Double d = new Double("123456789.123456789");
      
      Integer intObject = Integer.valueOf(5);
      Integer g = new Integer(5);
      
      Integer secondObject = Integer.valueOf("404");
      Integer k = new Integer("404");
           
      System.out.println(d.floatValue());
      System.out.println(d.byteValue());
      System.out.println(d.intValue());
      System.out.println(d.longValue());
      System.out.println(d.shortValue());
      System.out.println(d.doubleValue());
     
      BigInteger a = new BigInteger("9223372036854775807");
      BigInteger b = new BigInteger("2");
      BigInteger c = a.multiply(b);
      System.out.println(c); 
      BigInteger e = c.divide(b);
      System.out.println(e);
      if (e.equals(b)) {
         System.out.println("Output statement is as expected");
         
      }
      
      Integer thirdObject = Integer.parseInt("7");
      Double newDouble = Double.parseDouble("574839.67587365257");
      String s = "123456789.123456789";
      System.out.println(s.substring(5));
      System.out.println(s.substring(2, 8));

   }

}


