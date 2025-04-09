public class TestDie
{
   public static void main (String[] args)
   {
      Die d1=new Die();
      Die d2=new Die();
      System.out.println(d1.getFaceValue());
      int i=10;
      while(i>=0)
      {
         d1.roll();
         System.out.println(d1.getFaceValue());
         i-=1;
      }
     System.out.println(d1.getFaceValue);
     d1.setFaceValue(3);
     System.out.println(d1+"\n"+d2);
   }
}