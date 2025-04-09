// ************************************************************
// Circle.java
//
// Print the area of a circle with two different radii
// ************************************************************
import java.util.Scanner;
public class Circle
   {
   public static void main(String[] args)
      {
      final double PI = 3.14159;
      int radius, radius2;
      Scanner scan=new Scanner(System.in);
      System.out.println("Please enter Radius 1:");
      radius=scan.nextInt();
      radius2=radius*2;
      double area = PI * radius * radius;
      double circumference=radius*2*PI;
      System.out.println("The area of a circle with radius " + radius +
      " is " + area
      +", while the circumference is "+circumference);
      //Here's the thing
      double area2 = PI * radius2 * radius2;
      double circumference2=radius2*2*PI;
      System.out.println("The area of a circle with radius " + radius2 +
      " is " + area2
      +", while the circumference is "+circumference);
      //Here's the thing for step 1
      double areaChange=area2/area;
      double circumferenceChange=circumference2/circumference;
      System.out.println("Area Change: "+areaChange+"\nCircumference Change: "+circumferenceChange);
   }
}