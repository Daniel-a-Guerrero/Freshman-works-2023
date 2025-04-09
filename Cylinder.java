//*****************************************
// Cylinder.java
//
// Represents a cylinder.
//*****************************************
public class Cylinder extends Shape
{
private double radius, height; //Height and radius in feet
//----------------------------------
// Constructor: Sets up the cylinder.
//----------------------------------
public Cylinder(double r, double h)
{
super("Cylinder");
radius = r;
height=h;
}
//-----------------------------------------
// Returns the surface area of the cylinder.
//-----------------------------------------
public double area()
{
return height*Math.PI*Math.pow(radius,2);
}
//-----------------------------------
// Returns the cylinder as a String.
//-----------------------------------
public String toString()
{
return super.toString() + " of radius " + radius+" and of height "+ height;
}
}