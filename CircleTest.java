import java.util.Scanner;
public class CircleTest
{
   public static void main(String[] args)
   {
      Scanner scan=new Scanner(System.in);
      int r1, r2;
      System.out.println("Please input the value of circle 1:\n");
      r1=scan.nextInt();
      r2=(int)(Math.random()*11+5);
      CircleCon Circle1=new CircleCon(r1);
      CircleCon Circle2=new CircleCon(r2);
   }
}