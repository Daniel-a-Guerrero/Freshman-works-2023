public class PChecker
{
   public boolean isPalindrome(String pal)
   {
      int c=0;
      int p=pal.length();
      String copy="";
      for(int i=p;i>0;i--)
      {
         copy+=(pal.charAt(i-1));
      }
      if(pal.equals(copy))
      {
         return true;
      }
      else
         return false;
   }
}