abstract public class Shape{
protected String shapeName;
public Shape(String shapeName){this.shapeName=shapeName;}
public abstract double area();
public String toString(){return "Name of shape: "+shapeName;}
}