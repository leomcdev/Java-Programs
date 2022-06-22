import java.util.Scanner;

/*
 * Inledande programmering uppgift 4, Slumptal. 
 * In this program the user will input any random number between 0-999 and as many numbers as the user wishes. 
 * The program will then random the numbers and save them in an array. The program will then print out the 
 * numbers as they were inputted. In the next step the program will sort the numbers from the lowest even number
 * to the highest even number and same with uneven numbers. At the end the output will be shown by differencing the
 * even and uneven numbers from left to right.
 * @author Leo Bergquist Mcneil 
 
 * Flowchart - 
 * declare arrays and variables 
 * print out user information and save in keyboard next int 
 * print out the random numbers 
 * if random number is low, move to the left until sorted from low to high
 * if random number is even move to the left, if uneven move to the right
 * print out how many that was even and uneven 
 * exit program 
*/

public class Slumptal 
{

   public static void main(String args[]) 
   {
      // Declare variables
      int numbers, temp;
      
      //declare constants
      final int MIN_VALUE = 0;
      final int MAX_VALUE = 1000;

      // Create scanner
      Scanner scan = new Scanner(System.in);

      // Save user input into the array
      System.out.print("Input any numbers between 0-999: ");
      numbers = scan.nextInt();
      int arr[] = new int[numbers];
      
      // Declare variables in connection to the array (oddnumbers)
      int evenNumbers = 0;
      int oddNumbers = 0;

      // Print out unsorted numbers
      System.out.print("Here are the unsorted numbers: \n");
      for (int i = 0; i < numbers; i++) 
      {
         arr[i] = (int) (Math.random() * MAX_VALUE );
         System.out.printf(arr[i] + " ");
      }

      // Sort the numbers and place them in arrays
      for (int i = 0; i < numbers; i++) 
      {
         for (int j = i + 1; j < numbers; j++) 
         {
            if (arr[i] > arr[j]) 
            {
               temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
         }
      }
      
      // Print out the sorted numbers from low to high and high to low. Dividing even and odd numbers and printing them out
      System.out.print("\n\nHere are the sorted numbers:\n");
      for (int i = 0; i < numbers; i++) 
      {

         if (arr[i] % 2 == 0) 
         {
            System.out.print(arr[i] + " ");
            evenNumbers++;
         }
      }
      
      System.out.print("- ");
      
      for(int i = numbers -1; i >= 0; i--)
         {
         if (arr[i] % 2 != 0) 
         {
            System.out.print(arr[i] + " ");
            oddNumbers++;

         }
      }
      
      // Print out the outcome
      System.out.printf("\n\nOut of the %s numbers, even numbers are %s and odd numbers are %s", numbers, evenNumbers, oddNumbers);

   }
}
