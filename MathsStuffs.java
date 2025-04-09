public class MathsStuffs
{
   public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
   }
   public static int avg(int ... lizt)
   {
      int llength=lizt.length;
      int tot=0;
      for(int i=0;i<llength;i++)
      {
         tot+=lizt[i];
      }
      return tot/llength;
   }
   public static String printStringList(String ... sList)
   {
      String t="[";
      for(int i=0;i<sList.length;i++)
      {
         if(i<sList.length-1)
            t+=(sList[i]+", ");
         else if(i==sList.length-1)
            t+=(sList[i]+"]");
      }
      return t;
   }

}