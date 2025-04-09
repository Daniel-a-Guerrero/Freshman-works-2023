public class MathFormula
{
   private double perimeter, radius, length, width, sideLength, PI=3.14, CArea, RArea, SArea;
   public MathFormula (double r,double l,double w,double sL)
   {
      perimeter=(2*r*PI);radius=r;length=l;width=w;sideLength=sL;
   }
   public void setP(double nP)
   {
      perimeter=nP;
      radius=(nP/2)/PI;
   }
   public void setR(double nR)
   {
      radius=nR;
      perimeter=nR*2*PI;
   }
   public void setL(double nL)
   {
      length=nL;
   }
   public void setw(double nW)
   {
      width=nW;
   }
   public void setSL(double nSL)
   {
      sideLength=nSL;
   }
   public double getCircleArea()
   {
      CArea=(PI*radius*radius);
      return CArea;
   }
   public double getRectangleArea()
   {
      RArea=length*width;
      return RArea;
   }
   public double getSquareArea()
   {
      SArea=sideLength*sideLength;
      return SArea;
   }
   public String toString()
   {
      return "Circle Area: "+CArea+"\nRectangle Area: "+RArea+"\nSquare Area: "+SArea;
   }
}