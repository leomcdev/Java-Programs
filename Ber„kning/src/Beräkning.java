/**
 * Inledande programmering i java uppgift2. 
 * Computate how much money ones solarcells generates per day, based on hours. 
 * The program will take input from the user. Input as date, which can only be the month of june or july. 
 * Also the time for sunrise and sunset. Sunrise needs to be an earlier time then the sunset or an error will occur. 
 * If all the input is correct according to these steps, the program will print out the result and round off the decimal numbers if needed.
 * @author Leo Bergquist Mcneil 
  
 *Flowchart -
 * Initialization and declaration of constants and variables by giving them value
 * Create scanner objects and set delimeter
 * Print out questions for user and save userInput in strings
 * if date is not june or july, exit program
 * if date is june or july, print out "sunrise time..."
 * if sunset time is earlier then sunrise time, exit program"
 * if sunset time is later then sunrise time compute sun hours
 * Compute production
 * Compute electricity price and the production value earnings
 * Print out with 2 decimals
 */

import java.util.Scanner;
public class Beräkning 
{
   
  public static void main(String args[]) 
  {

    // Declare constants and give them value

    final int SOLAR_PANELS = 26; 
    final float SOLAR_PANELS_SIZE = 1.7f;  // meters
    final int SOLAR_PANELS_MAXW = 290;

    final float SOLAR_RADIATION = 166f; 
    final float SOLAR_EFFIENCY = 33.2f; 
    final float ELECTRICITY_PRICE = 0.9f; 
    final float THOUSAND = 1000.0f; 
    final int MIN_PER_HOUR = 60; 
    final int monthJune = 6;
    final int monthJuly= 7;
    final int daysJune = 30;
    final int daysJuly = 31; 
    
    // declare variables

    int day, month;
    float sunriseMinutes = 0; 
    float sunriseHours = 0;
    float sunsetMinutes;
    float sunsetHours;
    float todaysDateInput;
    float sunHours = 0;
    float production;
    float productionValue;

    // Creating scanner object for reading as userInput

    Scanner userInput = new Scanner(System. in );
    Scanner sunriseInput = new Scanner(System. in );
    Scanner sunsetInput = new Scanner(System. in );

    // Set delimiter to '-' or '/' or whitespace 
    userInput.useDelimiter("[-/\\s]+");
    sunriseInput.useDelimiter("[:|\\s]");
    sunsetInput.useDelimiter("[:|\\s]");

    // printing and saving the input from user  

    System.out.printf("Input todays date [mm-dd]>");
    month = userInput.nextInt();
    day = userInput.nextInt();

    // If the input from the user is not correct, exit program. If its correct, continue to next step. 
    
    if (month == monthJune & day <= daysJune | month == monthJuly & day <= daysJuly ) 
    {
      System.out.printf("Input time for sunrise [hh:mm]>");
      sunriseHours = sunriseInput.nextInt();
      sunriseMinutes = sunriseInput.nextInt();
    }
    else 
    {
      System.out.printf("Wrong date. Date needs to be June or July ");
      System.exit(0);
    }
    System.out.printf("Input time for sunset [hh:mm]>");
    sunsetHours = sunsetInput.nextInt();
    sunsetMinutes = sunsetInput.nextInt();

    if (sunriseHours > sunsetHours) 
    {
      System.out.printf("Sunrise time need to be earlier then sunset time");
      System.exit(0);
    }

    System.out.printf("==========================================\n");

    // Compute and print out sunHours

    sunHours = (sunsetHours + sunsetMinutes / MIN_PER_HOUR) - (sunriseHours + sunriseMinutes / MIN_PER_HOUR);
    System.out.printf("Soltimmar: %.2f hours", sunHours);

    // Production computation 1 W = 1000 kW, therefore divided by 1000

    production = SOLAR_RADIATION * sunHours * SOLAR_PANELS_SIZE * SOLAR_EFFIENCY / THOUSAND;

    // Electricity price computation

    productionValue = production * ELECTRICITY_PRICE;

    // Print out the production and round off to 2 decimals 

    System.out.printf("%nProduktionen 0%s-%s is %.2f kWh to a value of %.2f kr", month, day, production, productionValue);

  }
}