import java.util.Scanner;
import java.util.InputMismatchException;

public class Fahrenheit2CelsiusExceptions{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean success = false;
    int fahrenheit = 0;

    while(!success){
      try{
        System.out.print("Enter a Fahrenheit value : ");
        fahrenheit = input.nextInt();
        success = true;
      }
      catch(InputMismatchException e){
        System.out.println("Sorry, that wasn't an int.\nPlease try again.");
      }
      finally{
        input.nextLine();
      }
      
    }
    System.out.print("Enter the day of the week: ");
    String day = input.nextLine();

    double celsius = (5.0 / 9) * (fahrenheit - 32);
    System.out.printf("%s Fahrenheit        : %-10d\n", day, fahrenheit);
    System.out.printf("%s Celsius           : %-10.2f\n", day, celsius);
    input.close();
  }
}
