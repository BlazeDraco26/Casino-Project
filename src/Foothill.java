//Lab #7
//Jordan Cheng

import java.util.Scanner;

public class Foothill
{
   private static final String BAR = "BAR";
   private static final String CHERRIES = "cherries";
   private static final String SPACE = "space";
   private static final String SEVEN = "seven";
   
   // probability of obtaining bar is 38% (BAR_MAX - BAR_MIN) + 1
   private static final int BAR_MIN = 0; 
   private static final int BAR_MAX = 37;
   
   // probability of obtaining cherries is 40% (CHERRY_MAX - CHERRY_MIN) + 1
   private static final int CHERRY_MIN = BAR_MAX + 1; 
   private static final int CHERRY_MAX = CHERRY_MIN + 39;
   
   // probability of obtaining space is 7% (SPACE_MAX - SPACE_MIN) + 1
   private static final int SPACE_MIN = CHERRY_MAX + 1; 
   private static final int SPACE_MAX = SPACE_MIN + 6;
   
   // probability of obtaining seven is 15% (SEVEN_MAX - SEVEN_MIN) + 1
   private static final int SEVEN_MIN = SPACE_MAX + 1; 
   private static final int SEVEN_MAX = SEVEN_MIN + 14;
  
   static final boolean KEEP_LOOPING = true;
   
   // main method
   public static void main(String[] args)
   {
      int betValue;
      int multiplier;
      ThreeString pullString;
      do {
         betValue = getBet();
         if (betValue == 0) {
            break;
         }
         pullString = pull();
         multiplier = getPayMultiplier(pullString);
         display(pullString, multiplier * betValue);
      } while (KEEP_LOOPING);
      System.out.println("Thank you for playing!");
   }
   
   // obtain user bet
   public static int getBet() {
      Scanner obtainBet = new Scanner(System.in);
      String betAmount;
      int betValue;
      
      while (KEEP_LOOPING) {
         System.out.println("How much would you like to bet (1 - 50) "
               + "or 0 to quit?");
         betAmount = obtainBet.nextLine();
         betValue = Integer.parseInt(betAmount);
         if (betValue > 0 && betValue <= 50) {
            System.out.println("whirrrrrr .... and your pull is ... ");
            break;
         } else if (betValue == 0) {
            break;
         } else {
            System.out.println("Error: Invalid Input.");
         }
      }
      return betValue;
   }

   // obtain pull results
   public static ThreeString pull() {
      String[] pos = new String[3];
      for (int i = 0; i < 3; i++) {
         pos[i] = randString();
      }

      ThreeString slot = new ThreeString();
      slot.setString1(pos[0]);
      slot.setString2(pos[1]);
      slot.setString3(pos[2]);
      return slot;
   }
   
   // set parameters of possible results
   private static String randString() {
      String output = "";
      
      Double a = Math.random();
      Double b = Double.valueOf(a * 100);
      Integer c = b.intValue();
      if (c >= BAR_MIN && c <= BAR_MAX) {
         output = BAR;
      } else if (c >= CHERRY_MIN && c <= CHERRY_MAX) {
         output = CHERRIES;
      } else if (c >= SPACE_MIN && c <= SPACE_MAX) {
         output = SPACE;
      } else if (c >= SEVEN_MIN && c <= SEVEN_MAX) {
         output = SEVEN;
      }
      return output;
   }
   
   // obtain bet multiplier
   private static int getPayMultiplier(ThreeString thePull) {
      int payMultiplier = 0;
      if (thePull.getString1() == SEVEN && thePull.getString2() == SEVEN
            && thePull.getString3() == SEVEN) {
         payMultiplier = 100;
      } else if (thePull.getString1() == BAR && thePull.getString2() == BAR
            && thePull.getString3() == BAR) {
         payMultiplier = 50;
      } else if (thePull.getString1() == CHERRIES && thePull.getString2() == 
            CHERRIES && thePull.getString3() == CHERRIES) {
         payMultiplier = 30;
      } else if (thePull.getString1() == CHERRIES && thePull.getString2() ==
            CHERRIES && (thePull.getString3() == BAR || thePull.getString3()
            == SEVEN || thePull.getString3() == SPACE)) {
         payMultiplier = 15;
      } else if (thePull.getString1() == CHERRIES && (thePull.getString2() ==
            BAR || thePull.getString2() == SEVEN ||
            thePull.getString2() == SPACE)) {
         payMultiplier = 5;
      } else {
         payMultiplier = 0;
      }
      return payMultiplier;
   }
   
   // print result of gamble
   public static void display (ThreeString thePull, int winnings) {
      System.out.println(thePull.toString());
      if (winnings > 0) {
         System.out.println("Congrats! You win: " + winnings);
      } else {
         System.out.println("Sorry, you lose.");
      }
   }

}

// ThreeString class
class ThreeString
{
   private String string1;
   private String string2;
   private String string3;
   private static final String BLANK = " ";
   
   public static final String DEFAULT_STRING = " (undefined) ";
   public static final int MAX_LEN = 50;
   public static final int MIN_LEN = 1;
   
   //constructors  
   public ThreeString() {
      string1 = DEFAULT_STRING;
      string2 = DEFAULT_STRING;
      string3 = DEFAULT_STRING;
   }
   
   public ThreeString(String string1, String string2, String string3) {
      boolean result1 = setString1(string1);
      boolean result2 = setString2(string2);
      boolean result3 = setString3(string3);
      
      if (result1 == false) {
         this.string1 = DEFAULT_STRING;
      }
      if (result2 == false) {
         this.string2 = DEFAULT_STRING;
      }
      if (result3 == false) {
         this.string3 = DEFAULT_STRING;
      }
   }

   
   //mutators and accessors
   public String getString1()
   {
      return string1;
   }
   
   public boolean setString1(String string1)
   {
      if(validString(string1))
      {
         this.string1 = string1;
         return true;
      }
      else
      {
         //do nothing at all
         return false;
      }
   }
      
   public String getString2()
   {
      return string2;
   }
      
   public boolean setString2(String string2)
   {
      if(validString(string2))
      {
         this.string2 = string2;
         return true;
      }
      else
      {
         return false;
      }
  
   }
   
   public String getString3()
   {
      return string3;
   }
      
   public boolean setString3(String string3)
   {
      if(validString(string3))
      {
         this.string3 = string3;
         return true;
      }
      else
      {
         return false;
      }
      
   }
   
   public String toString() {
      return string1 + BLANK + string2 + BLANK + string3;
   }

   private static boolean validString( String str ) {
      if (str != null && str.length() <= MAX_LEN && str.length() >= MIN_LEN) {
         return true;
      } else {
         return false;
      }
   }

}

// I obtained a pull of all cherries in pulls 13 and 18
// I obtained a pull of all BARS in pulls 17 and 35

/* ------------------------------ run ---------------------------------------

How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries seven cherries
Congrats! You win: 10
How much would you like to bet (1 - 50) or 0 to quit?
-2
Error: Invalid Input.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR cherries BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR cherries BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
seven BAR space
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
seven cherries BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
seven BAR cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries space BAR
Congrats! You win: 10
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries space BAR
Congrats! You win: 10
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR seven BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
seven cherries seven
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
seven BAR BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries cherries cherries
Congrats! You win: 60
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR cherries cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR cherries cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR seven seven
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR BAR BAR
Congrats! You win: 100
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries cherries cherries
Congrats! You win: 60
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries cherries BAR
Congrats! You win: 30
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
seven cherries cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries BAR BAR
Congrats! You win: 10
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR BAR cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries space cherries
Congrats! You win: 10
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR cherries space
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR BAR seven
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
space cherries seven
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
seven space BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
seven BAR BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries BAR BAR
Congrats! You win: 10
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries BAR seven
Congrats! You win: 10
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries cherries seven
Congrats! You win: 30
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR cherries BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
cherries seven BAR
Congrats! You win: 10
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR cherries seven
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR BAR BAR
Congrats! You win: 100
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR seven BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ... 
BAR BAR cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
50
whirrrrrr .... and your pull is ... 
BAR cherries BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ... 
seven BAR cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?
51
Error: Invalid Input.
How much would you like to bet (1 - 50) or 0 to quit?
0
Thank you for playing!


--------------------------------------------------------------------------- */
