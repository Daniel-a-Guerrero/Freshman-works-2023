public class CircleCon
{
   private int r;
   public CircleCon(int radius)
   {
      r=radius;
   }
   public CircleCon()
   {
      r=5;
   }
   public void setRadius(int radius)
   {
      r=radius;
   }
   public int getRadius()
   {
      return r;
   }
   public double getArea()
   {
      return Math.PI*Math.pow(r,2);
   }
   public String toString()
   {
      return ""+r;
   }
}