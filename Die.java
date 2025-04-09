
public class Die implements Comparable<Die>
{
   private int faceValue;
   //constructor
   public Die()
   {
      faceValue=6;
   }
   //roll method
   public void roll()
   {
      faceValue=(int)(Math.random()*6)+1;
   }
   public int getFaceValue()
   {
      return faceValue;
   }
   public boolean equalTo(Die die2)
   {
      return (faceValue==die2.getFaceValue());
   }
   public int compareTo(Die die2)
   {
      if (faceValue>die2.getFaceValue())
         return 1;
      else if(faceValue==die2.getFaceValue())
         return 0;
      else
         return -1;
   }
   public void setFaceValue(int newFace)
   {
      faceValue=newFace;
   }
   public String toString()
   {
      return "Die with face"+faceValue;
   }
}