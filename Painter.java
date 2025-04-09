import java.util.Scanner;
public class Painter{
   public static void main(String[] args)
   {
      final int COVERAGE = 350; //paint covers 350 sq ft/gal
      int length, width, height;
      double totalSqFt, paintNeeded;
      Scanner scan=new Scanner(System.in);
      length = scan.nextInt();
      width = scan.nextInt();
      height = scan.nextInt();
      System.out.println("How many windows are there?");
      int windows=scan.nextInt();
      System.out.println("How many doors are there?");
      int doors=scan.nextInt();
      totalSqFt=(2*((length*width)+(width*height)+(length*height)))-(doors*20)-(windows*15);
      paintNeeded=totalSqFt/COVERAGE;
      System.out.println("Width: "+width+"\nHeight: "+height+"\nLength: "+length+"\nGallons needed: "+paintNeeded);
      System.out.println("SA: "+totalSqFt);
   }
}