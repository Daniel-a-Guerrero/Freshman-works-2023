// ************************************************************
// Temps.java
//
// This program reads in a sequence of hourly temperature
// readings (beginning with midnight) and prints the maximum
// temperature (along with the hour, on a 24-hour clock, it
// occurred) and the minimum temperature (along with the hour
// it occurred).
// ************************************************************
import java.util.Scanner;
public class Temps
{
// --------------------------------------------------
// Reads in a sequence of temperatures and finds the
// maximum and minimum read in.
// --------------------------------------------------
public static void main (String[] args)
{
final int HOURS_PER_DAY = 24;
int temp; // a temperature reading
int lowest=69, lTime=420, highest=0, hTime=0;
Scanner scan = new Scanner(System.in);
// print program heading
System.out.println ();
System.out.println ("Temperature Readings for 24 Hour Period");
System.out.println ();
for (int hour = 0; hour < HOURS_PER_DAY; hour++)
{
System.out.print ("Enter the temperature reading at " + hour +
" hours: ");
temp = scan.nextInt();
if(hour==0){lowest=temp;lTime=hour;}
else{if(temp<lowest){lowest=temp;lTime=hour;}}
if(hour==0){highest=temp;hTime=hour;}
else{if(temp>cichighest){highest=temp;hTime=hour;}}
}
System.out.println("Lowest is "+lowest+" degrees at "+lTime+" hours");
System.out.println("Highest is "+highest+" degrees at "+hTime+" hours");
// Print the results
}
}