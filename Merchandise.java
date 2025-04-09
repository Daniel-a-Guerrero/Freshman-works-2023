//********************************************************************
//  Merchandise.java       Author: Guerrero, Daniel
//
//  Represents a piece of merchandise. Used as the parent of a derived class to
//  demonstrate inheritance.
//********************************************************************
import java.text.NumberFormat;
public class Merchandise
{
   protected double price;
   protected String name;
   NumberFormat fmt = NumberFormat.getCurrencyInstance();
   //----------------------------------------------------------------
   //  Specific constructor.
   //----------------------------------------------------------------
   public Merchandise(double p, String n)
   {
      price=p;
      name=n;
   }
   
   //----------------------------------------------------------------
   //  Default constructor.
   //----------------------------------------------------------------
   public Merchandise()
   {
      price=0;
      name="null";
   }
   //----------------------------------------------------------------
   //  Price mutator.
   //----------------------------------------------------------------
   public void setPrice(double price)
   {
      this.price = price;
   }
   
   //----------------------------------------------------------------
   //  Price accessor.
   //----------------------------------------------------------------
   public double getPrice()
   {
      return price;
   }
   
   //----------------------------------------------------------------
   //  Name mutator.
   //----------------------------------------------------------------
   public void setName(String n)
   {
      name = n;
   }
   
   //----------------------------------------------------------------
   //  Name accessor.
   //----------------------------------------------------------------
   public String getName()
   {
      return name;
   }
   
   //----------------------------------------------------------------
   // toString method.
   //----------------------------------------------------------------
   public String toString()
   {
      String returner="Product name: "+name+"\nPrice: "+fmt.format(price);
      return returner;
   }
}