import java.util.Random;
public class RandomPlate
{
   public static void main (String[] args)
   {
      final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      Random rand=new Random();
      int loc=rand.nextInt(26);
      int loc1=rand.nextInt(26);
      int loc2=rand.nextInt(26);
      String c1=ALPHABET.substring(loc,(loc+1));
      String c2=ALPHABET.substring(loc1,(loc1+1));
      String c3=ALPHABET.substring(loc2,(loc2+1));
      int dec=rand.nextInt(9);
      int dec1=rand.nextInt(9);
      int dec2=rand.nextInt(9);
      int dec3=rand.nextInt(9);
      System.out.println("Plate ID: "+c1+c2+c3+dec+dec1+dec2+dec3);
   }
}