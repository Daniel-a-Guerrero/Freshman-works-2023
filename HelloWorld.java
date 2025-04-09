import java.util.Random;
public class HelloWorld {

	public static void main(String[] args) {
      Random generator=new Random();
      int the;
      String funny="Finland";
      System.out.println(funny);
      funny=funny.concat(" sucks");
      System.out.println(funny);
      funny=funny.toUpperCase();
      System.out.println(funny);
      funny=funny.replace("I","U");
      System.out.println(funny);
      funny=funny.substring(3,7);
      System.out.println(funny);
      int unfunny=funny.length();
      System.out.println(unfunny);
      String sample="_"+funny;
      while(unfunny>=0)
         {
         funny=funny.concat(sample);
         unfunny=unfunny-1;
         }
      System.out.println(funny);
      unfunny=(generator.nextInt(10));
      while(unfunny!=0)
      {
      the=+1;
      System.out.println(unfunny);
      unfunny=generator.nextInt(10);
      }
   }
}