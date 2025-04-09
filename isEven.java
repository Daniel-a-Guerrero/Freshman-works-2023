//Program that takes in a number and determines if it is even or odd
import java.util.*;
public class isEven
{
   public static void main (String[] args)
   {
      Random r=new Random();
      Scanner scan=new Scanner(System.in);
      //Asks user for integer
      System.out.println("Enter an integer");
      int num=scan.nextInt();
      System.out.println("Num is "+((num%2==1)?"Odd":"Even"));
      //Continually asks for prime num until it is given
      System.out.println("Now enter a prime number");
      num=scan.nextInt();
      if(MathsStuffs.isPrime(num)==false)
      {
         while(MathsStuffs.isPrime(num)==false);
         {
            System.out.println("That number isn't prime");
            num=scan.nextInt();
         }
      }
      
      //prints average of a list of 3 random numbers 0 to 10
      
      int[] li={r.nextInt(10),r.nextInt(10),r.nextInt(10)};
      System.out.println("["+li[0]+", "+li[1]+", "+li[2]+"]"+"\t"+MathsStuffs.avg(li));
      String[] s={"cat", "sat", "mat"};
      System.out.println(MathsStuffs.printStringList(s));
   }
}