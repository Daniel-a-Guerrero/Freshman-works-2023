public class LP_Book
{
   private String title, author;
   private int IDNum;

   //constructor
   
   public LP_Book(String title, String author, int id)
   {
      this.title=title;
      this.author=author;
      this.IDNum=id;
   }
   
   //Title setter and getter
   
   public static setTitle(String title)
   {
      this.title=title;
   }
   public String getTitle()
   {
      System.out.println(title);
   }
   
   //Author setter and getter
   
   public static setAuthor(String author)
   {
      this.author=author;
   }
   public String getAuthor()
   {
      System.out.println(author);
   }
   
   //ID number setter and getter
   
   public static setIDNum(int IDNum)
   {
      this.author=author;
   }
   public String getIDNum()
   {
      System.out.println(IDNum);
   }
   //To String
   public String toString()
   {
      return "ID: " + IDNum + ", Title: " + title + ", Author: " + author;
   }
}