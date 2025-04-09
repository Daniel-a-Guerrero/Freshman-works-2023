import java.util.ArrayList;
public class LibraryProject_LP
{
   private ArrayList<LP_Book> collection = new ArrayList<LP_Book>();
   private LP_Book book;
   //Method to add books to the library
   
   public void addBooks(String book, String author)
   {
      int id = books.size() + 1;
      book=new LP_Book(book, author, size);
      collection.add(id,book);
      
   }
   
   //Method to remove books from the library
   
   public void removeBooks(int id)
   {
      LP_Book bookToRemove = null;
        for (LP_Book book : collection)
        {
            if (book.getId() == id)
            {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null)
        {
            collection.remove(bookToRemove);
            System.out.println("Book removed: " + bookToRemove);
        }
        else
        {
            System.out.println("Book not found with ID: " + id);
        }
   }
   
   //Method to display the library books
   
   public LP_Book[] displayBooks()
   {
      System.out.println("Library books:");
        for (Book book : books) {
            System.out.println(book);
        }
   }
}