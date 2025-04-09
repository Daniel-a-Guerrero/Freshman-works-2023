//********************************************************************
//  Keychain.java       Author: Guerrero, Daniel
//
//  Represents a keychain, which is a piece of merchandise. Used to
//  demonstrate inheritance.
//********************************************************************
public class Keychain extends Merchandise
{
   protected int size;
   //----------------------------------------------------------------
   //  Specific constructor.
   //----------------------------------------------------------------
   public Keychain(int size, double pr, String na)
   {
      super(pr,na);
      if(size>4)
         this.size=4;
      else if(size<1)
         this.size=1;
      else
         this.size=size;
   }
   
   //----------------------------------------------------------------
   //  Default constructor.
   //----------------------------------------------------------------
   public Keychain()
   {
      size=0;
      name="Null";
      price=0;
   }

   //----------------------------------------------------------------
   //  Size mutator.
   //----------------------------------------------------------------
   public void setSize(int size)
   {
      if(size>4)
         this.size = 4;
      else if(size<1)
         this.size = 1;
      else
         this.size = size;
   }
   
   //----------------------------------------------------------------
   //  Size accessor.
   //----------------------------------------------------------------
   public int getSize()
   {
      return size;
   }
   
   //----------------------------------------------------------------
   //  toString method.
   //----------------------------------------------------------------
   public String toString()
   {
      String returner="Keychain description: "+name+"\nSize number: "+size+"\t\tPrice: "+fmt.format(price);
      return returner;
   }

}