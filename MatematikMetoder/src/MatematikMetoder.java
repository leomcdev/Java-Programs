import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class MatematikMetoder 
{

private static Scanner userInput = new Scanner(System.in);

/* 
 * In this program all information from the user shall be inputted in the methods
 * and be printed out in main, except the method printfraction. First the program will read 
 * radius and height and when user input is q, it will move to the next step
 * and print out the nominator and denominator. It should be possible to input
 * multiple of values without any error occuring or program is shutting down.
 * all input from user will be integers or q. The outprint will be with 2 decmimals


 * Flowchart - 
 * Declare variables in each method as you go. First method one, area(int radius) 
 * input from user and save in userInput
 * Compute the base area (circles area)
 * B = area^2
 * use math.pow(double a, double b) a is base and b is the exponent 
 * return (print out) the area as a float 
 * 
 * area(int radius, int height) 
 * input from user and saver in userInput
 * input is radius and height
 * calculate 
 * return value as float
 * 
 * volume area(int radius, int height) 
 * input from user and saver in userInput
 * input is radius and height
 * calucate
 * return value as float
 * 
 * if user input is q, move to next part
 * 
 * fraction(int nominator, int denominator)
 * input from user, save in user input
 * input is nominator and denominator
 * calculate
 * return as an array 
 * 
 * sgd(int a, int b)
 * calculate and short the fraction
 * return calculated value 
 * 
 * printfraction(int[] parts)
 * save input from user
 * if first place in array is 0, == no whole number
 * if second place is 0 no fractionpart 
 * if third place is 0 print out 0
 * else print out null
 * if user input is q, exit program
 */

public static void main(String args[])
{
   // declare and initialize variables  
   float r;
   float s;
   float v;
   int a = 0;
   
   //  array to print out 
   int [] f = new int [3];

   
   // declare integers
   Integer radius;
   Integer height;
   Integer nominator;
   Integer denominator; 
   
   // round to 2 decimal  
   DecimalFormat df = new DecimalFormat("00.00");
   
   // if negative int input, convert
   a = Math.abs(a);
   
   // outprint
   System.out.printf("----------------------------------\n" + "# Test av area och volymmetoderna\n"
         + "---------------------------------- \n>");
   
   // if radius and height input equals to null, break
   while (true)
   {
      radius = input(); 
      if (radius == null)      
         break;
      height = input(); 
      if (height == null)
         break;
      
   // print out radius and height
   System.out.println("r = " + radius + " h = " + height);

   // print out radiusarea
   r = area(radius); 
   System.out.println("Basytans area is: " + df.format(r));
   
   // print out surfacearea
   s = area(radius,height);
   System.out.println("Mantelytans area is: " + df.format(s)); 
   
   // print out volume
   v = volume(radius,height);
   System.out.println("Volumes area is: " + df.format(v) + "\n");
   }
   
   // outprint
   System.out.printf("----------------------------------\n" + "# Test av bråktalsmetoderna\n"
         + "---------------------------------- \n>");
   
   /* start of nominator and denominator calculation
   if radius and height input equals to null, break
   */
   while (true)
   {
      nominator = input(); 
      if (nominator == null)
      {
         break;
      }
      denominator = input(); 
      if (denominator == null)
      {
         break;
      }
      
      //print fraction 
      f = fraction(nominator, denominator);
      System.out.print(nominator + "/" + denominator + " = ");
      printFraction(f);
      }
} 

// input from user
public static Integer input() 
{
   // declare variable that take in ints
   int input = Integer.MAX_VALUE;
  
   // if the user input is not an int or negative, convert and then if input is q return nothing
   while (true)
      {
      if (userInput.hasNextInt())
      {
      input = userInput.nextInt();
      return Math.abs(input);
      }
      if (userInput.next().equals("q"))
      {
         return null;
      }     
   }
}

// compute the different calculations and return them to main
public static float area(int radius)      
{
   //declare variable and initialize constant
   double sumBaseArea; 
   
   //compute and return
   sumBaseArea = (float) ((float) Math.PI * Math.pow(radius, 2)); 
   return (float) sumBaseArea; 
} 

public static float area(int radius, int height) 
{ 
   // declare variable
   double m;
   
   //compute and return
   double s = pythagoras(radius,height);
   m = (float) (Math.PI * radius * s);
   return (float) m; 
}

public static float pythagoras (int sideA, int sideB)
{ 
   //declare variable and initialize constant
   double c = 0; 
   
   //compute and return
   c =  Math.sqrt(Math.pow(sideA,2) + Math.pow(sideB,2));
   return (float) c;
}

public static float volume(int radius, int height) 
{   
   // declare variable and initialize constant
   double v;
   
   //compute and return
   v = Math.PI * Math.pow(radius,2) * height / 3;
   return (float) v;  
}

// compute and and shorten the nominator and denominator
public static int[] fraction(int nominator, int denominator) 
{
   // declare and initialize variables
   int quote;
   int nominatorRest;
   int denominatorRest;
   int shorting;
   int restNom;
   int restDom;
   int[] zero = {0,0,0};
   
   if (denominator == 0) 
   {
      return null;
   }
   else if (nominator == 0) 
   {
      return zero;
   }
   else    
   { 
      
   // call function sgd
   shorting = sgd(nominator, denominator);
   
   // short nominator and denominator 
   nominatorRest = nominator / shorting;
   denominatorRest = denominator / shorting; 
   
   // calculate new value
   quote = nominator / denominator;
   restNom = nominatorRest % denominatorRest;
   restDom = denominatorRest; 
    
   int [] arr = {quote, restNom, restDom};
 
   return arr;
   }
}


// the short calculation to get sent back to fraction
public static int sgd(int a, int b) {
   
  int c;
  
  if (a > b) 
  {
     c = a % b;
     a = b;
     b = c;
  }
     while (b != 0) 
     {
        c = a % b;
        a = b;
        b = c;
     }
   return a;  
}

// print out the array in correct order as whats inputted from user
public static void printFraction(int[] parts)
{
   if (parts == null)
   {
      System.out.println("Error");
   } 
   else if (parts[0] == 0)
   {
      System.out.println(parts[1] + "/" + parts[2]);
   } 
   else if (parts[1] == 0)
   {
      System.out.println(parts[0]);
   } 
   else if (parts[2] == 0)
   {
      System.out.println("0");
   } 
   else
   {
      // print out everything if no value equals to 0
      System.out.println(parts[0] + " " + parts[1] + "/" + parts[2]);
   }
}
}





 