//********************************************************************
//  Book.java       Author: Guerrero, Daniel
//
//  Represents a book, which is a piece of merchandise. Used to
//  demonstrate inheritance.
//********************************************************************
public class Book extends Merchandise
{
   protected int pageNumber;
   protected String author;
   //----------------------------------------------------------------
   //  Specific constructor.
   //----------------------------------------------------------------
   public Book(String na, String a, double pr, int pn)
   {
      super(pr, na);
      pageNumber=pn;
      author=a;
   }
   
   //----------------------------------------------------------------
   //  Default constructor.
   //----------------------------------------------------------------
   public Book()
   {
      super(0, "null");
      pageNumber=0;
      author="N/A";
   }
   
   //----------------------------------------------------------------
   //  Page number mutator.
   //----------------------------------------------------------------
   public void setPageNumber(int pN)
   {
      pN = pageNumber;
   }
   
   //----------------------------------------------------------------
   //  Page number accessor.
   //----------------------------------------------------------------
   public int getPageNumber()
   {
      return pageNumber;
   }
      
   //----------------------------------------------------------------
   //  Author mutator.
   //----------------------------------------------------------------
   public void setAuthor(String author)
   {
      this.author = author;
   }
   
   //----------------------------------------------------------------
   //  Author accessor.
   //----------------------------------------------------------------
   public String getAuthor()
   {
      return author;
   }
   
   //----------------------------------------------------------------
   // toString method.
   //----------------------------------------------------------------
   public String toString()
   {
      String returner="Title: "+name+", by "+author+";\n"+pageNumber+" pages\t\tPrice: "+fmt.format(price);
      return returner;
   }
}