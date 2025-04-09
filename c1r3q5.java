public class c1r3q5
{
   public static void main(String [] args)
   {
      boolean flag = false; 
      int x;
      for(x=4; !flag; x-=1)
      {
         if(x < 3)
         { 
            flag = true;
         }
         System.out.println(x);
      }
      /*
      int num;
      for (num=100; num > 0; num -= 5)
         System.out.println(num);
      System.out.println(num);*/
   }
}