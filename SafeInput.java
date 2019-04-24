
import java.util.Scanner;

/**
 *
 * @author gasawase
 */
public class SafeInput 
{
    /**
    * 
    * @param pipe a Scanner opened to read from System.in
    * @param prompt prompt for the user
    * @return a String response that is not zero length
    */ 
   public static String getNonZeroLenString(Scanner pipe, String prompt)
   {
       String retString = "";  // Set this to zero length. Loop runs until it isn’t zero
       do
       {
           System.out.print("\n" +prompt + ": "); // show prompt add space
           retString = pipe.nextLine();
       }while(retString.length() == 0);//* measures how many characters the user types
       
       return retString;
       
   }
   /**
    * Get an integer from the user in a specified inclusive range
    * @param pipe a Scanner opened on System.in
    * @param prompt tells the user what to enter does not include range
    * @param low low inclusive bound
    * @param high high inclusive bound
    * @return integer in the specified range
    */
   public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
   {
       int userVal = 0;
       String trash = "";
       boolean done = false; //* because not done when you start the process
       
       do
       {
           System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
           
           if (pipe.hasNextInt())
           {
               userVal=pipe.nextInt();
               pipe.nextLine();
               if (userVal >= low && userVal <= high)
               {
                   done = true;
               }
               else
               {
                   System.out.println("Number is out of range [" + low + " - " + high + "].");
               }
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println("You entered " + trash + ". Try again.");
           }
       }while(!done);
       return userVal;
   }
   /**
    * Get an double from the user in a specified inclusive range
    * @param pipe a Scanner opened on System.in
    * @param prompt tells the user what to enter does not include range
    * @param low low inclusive bound
    * @param high high inclusive bound
    * @return double in the specified range
    */
      public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
   {
       double userVal = 0;
       String trash = "";
       boolean done = false; //* because not done when you start the process
       
       do
       {
           System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
           
           if (pipe.hasNextDouble())
           {
               userVal=pipe.nextDouble();
               pipe.nextLine();
               if (userVal >= low && userVal <= high)
               {
                   done = true;
               }
               else
               {
                   System.out.println("Number is out of range [" + low + " - " + high + "].");
               }
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println("You entered " + trash + ". Try again.");
           }
       }while(!done);
       return userVal;
   }
      /**
       * Get a Y or N from user and displays true or false respectively
       * @param pipe a Scanner opened on System.in
       * @param prompt tells the user what to input does not include Y|N
       * @return true or false based on Y|N
       */
      public static boolean getYNConfirm(Scanner pipe, String prompt)
      {
          boolean done = false;
          String userVal = ""; //* should be Y or N
          boolean retVal = false;
          
          do
          {
              System.out.print("\n" + prompt + " [Y|N]: ");
              userVal = pipe.nextLine();
              
              if (userVal.equalsIgnoreCase("Y"))
              {
                  done = true;
                  retVal = true;
              }
              else if (userVal.equalsIgnoreCase("N"))
              {
                  done = true;
                  retVal = false;
              }
              else
              {
                  System.out.println("\nYou must enter [Yy | Nn]. Not " +userVal);
              }
          }while (!done);
          return retVal;
      }
      public static String getRegExMatch(Scanner pipe, String prompt, String regEx)
      {
          String retVal = "";
          boolean done = false;
          
          do
          {
              System.out.print("\n" + prompt+ ": ");
              retVal = pipe.nextLine();
          }while(!retVal.matches(regEx));
          return retVal;
      }
}
