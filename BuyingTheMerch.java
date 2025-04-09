//********************************************************************
//  BuyingTheMerch.java       Author: Guerrero, Daniel
//
//  Demonstrates the use of an inherited method
//********************************************************************
import java.text.NumberFormat;
import java.util.Scanner;
public class BuyingTheMerch
{
   public static void main(String[] args)
   {
      Scanner scan=new Scanner(System.in);
      int capacity;
      System.out.println("How many things would you like to purchase?");
      while(capacity==null)
      {
         try
         {
            capacity=scan.nextInt();
         }
         catch(InputMismatchException exception)
         {
            System.out.println("Please enter an integer.");
         }
      }
      System.out.println(capacity);
      Merchandise bag[]=new Merchandise[3];
      NumberFormat fmt=NumberFormat.getCurrencyInstance();
      double wholeCost=0;
      Book book1=new Book("How to walk", "John Johnson", 13, 4);
      System.out.println(book1);
      wholeCost+=book1.getPrice();
      Keychain k=new Keychain(3,12.5,"Pickle Rick Keychain");
      System.out.println(k);
      wholeCost+=k.getPrice();
      System.out.println("Total cost: "+fmt.format(wholeCost));
   }
}