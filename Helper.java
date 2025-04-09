public class Helper
{
   public static int cube(int num)
   {
      return num * num * num;
   }
   public static int exponent(int num, int exponent)
   {
      int x=0;
      int derf=1;
      while (x<exponent)
      {
         x++;
         derf=num*derf;
      }
      return derf;
   }
}