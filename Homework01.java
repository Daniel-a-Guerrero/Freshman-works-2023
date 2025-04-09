//Daniel Guerrero
//ID: 31588304
import java.util.Scanner;
public class Homework01
   {
   public static void main (String[] args)
      {
         double Fahrenheit=100.0, Celsius=((Fahrenheit-32)*5)/9;
         int Seconds, Minutes, Hours;
         System.out.println("Fahrenheit: "+Fahrenheit+"°\nCelsius: "+Celsius+"°");
         Scanner scan=new Scanner(System.in);
         System.out.println("Enter the number of seconds, please: ");
         Seconds=scan.nextInt();
         Minutes=Seconds/60;
         Hours=Minutes/60;
         Seconds=Seconds-(Minutes*60);
         Minutes=Minutes-(Hours*60);
         System.out.println("Hours: "+Hours);
         System.out.println("Minutes: "+Minutes);
         System.out.println("Seconds: "+Seconds);
      }
   }