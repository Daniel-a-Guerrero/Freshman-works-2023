public class rollUntil
{
   public static void main(String[] args)
   {
      Die d1=new Die(), d2=new Die();
      d1.roll();
      d2.roll();
      while (d1.equalTo(d2)==false)
      {
         if(d1.getFaceValue()%2=1 && d2.getFaceValue()%2=1)
         {
            System.out.println("Die 1: "+d1.getFaceValue()+"\tDie 2: "+d1.getFaceValue());
         }
      }
   }
}