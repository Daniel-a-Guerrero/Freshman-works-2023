import java.util.Scanner;
public class Factorial
{
   public static void main (String[] args)
   {
      int n, ans=1;
      Scanner scan=new Scanner(System.in);
      n=scan.nextInt();
      while (n<=0)
      {System.out.println("Please enter again");n=scan.nextInt();}
      while(n>0)
      {ans=ans*n;n--;}
      System.out.println(ans);
   }
}