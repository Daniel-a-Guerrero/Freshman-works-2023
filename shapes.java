public class shapes
{
   public static void main (String[] args)
   {
      MathFormula mf1=new MathFormula(3,5,7,9);
      System.out.println(mf1.getCircleArea());
      System.out.println(mf1.getRectangleArea());
      System.out.println(mf1.getSquareArea());
   }
}