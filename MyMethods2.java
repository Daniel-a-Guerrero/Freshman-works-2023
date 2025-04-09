public class MyMethods2
{
   public MyMethods2()
   {
   }
   public int volume(int width,int length,int height)
   {
      return (width*length*height);
   }
   public double avgFaceValues(Die d1, Die d2)
   {
      d1.roll();
      d2.roll();
      double thing=Double.valueOf(d1.getFaceValue());
      double things=Double.valueOf(d2.getFaceValue());
      double ozymandias=((thing+things)/2);
      return ozymandias;
   }
}