import java.util.Scanner;
public class Kennel
{
   public static void main (String[] args)
   {
      Scanner scan=new Scanner(System.in);
      Dog d1=new Dog();
      Dog d2=new Dog();
      System.out.println("Dog 1:\nInsert name:");
      String n1=scan.next();
      System.out.println("\nInsert weight");
      Double w1=scan.nextDouble();
      System.out.println("\n\nDog 2:\nInsert name:");
      String n2=scan.next();
      System.out.println("\nInsert weight");
      Double w2=scan.nextDouble();
      d1.setName(n1);
      d1.setWeight(w1);
      d2.setName(n2);
      d2.setWeight(w2);
      System.out.println(d1+"\n\n"+d2);
   }
}