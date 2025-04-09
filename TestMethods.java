public class TestMethods
{
   public static void main(String[] args)
   {
      Die D1=new Die(), D2=new Die();
      MyMethods2 m1=new MyMethods2();
      System.out.println(m1.avgFaceValues(D1,D2));
   }
}