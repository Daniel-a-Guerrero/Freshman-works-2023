import java.util.Scanner;
public class palCheck
{
   public static boolean caseSensitive=true;
   public static boolean onlyLetters=true;
   public static void main (String[] args)
   {
      Scanner sc=new Scanner(System.in);
      String st="";
      while(!(st.toLowerCase().equals("yes")||st.toLowerCase().equals("no")))
      {
         System.out.println("Do you want to make the program case sensitive (yes or no)?");
         st=sc.nextLine();
         st=st.toLowerCase();
         switch(st)
         {
            case "yes":
               caseSensitive=true;
               break;
            case "no":
               caseSensitive=false;
               break;
            default:
               System.out.println("Please enter \"yes\" or \"no\"");
               break;
         }
      }
      st="";
      while(!(st.equals("yes")||st.equals("no")))
      {
         System.out.println("Do you want to include non-letters (yes or no)?");
         st=sc.nextLine();
         st=st.toLowerCase();
         switch(st)
         {
            case "yes":
               onlyLetters=true;
               break;
            case "no":
               onlyLetters=false;
               break;
            default:
               System.out.println("Please enter \"yes\" or \"no\"");
               break;
         }
      }
      System.out.println("Enter the text that you want to check to see if it's a palindrome:");
      String scan=sc.nextLine();
      System.out.println(isPalindrome(scan));
   }
   public static boolean isPalindrome(String pal)
   {
      if(caseSensitive==false)
      {
         pal=pal.toLowerCase();
      }
      if(onlyLetters==false)
      {
         String pa="";
         for(int i=0;i<pal.length();i++)
         {
            if(Character.isLetter(pal.charAt(i)))
            {
               pa+=(pal.charAt(i));
            }
         }
         pal=pa;
      }
      int c=0;
      int p=pal.length();
      String copy="";
      for (int i = p; i > 0; i--) {
    copy += pal.charAt(i - 1);
}
      if(pal.equals(copy))
      {
         return true;
      }
      else
         return false;
   }
}