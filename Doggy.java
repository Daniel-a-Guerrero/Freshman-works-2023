public class Doggy
{
   private double weight;
   private String name;
   //constructor
   public Dog()
   {
      name="Dog";
      weight=0.0;
   }
   public double getWeight()
   {
      return weight;
   }
   public String getName()
   {
      return name;
   }
   public void setWeight(double newWeight)
   {
      weight=newWeight;
   }
   public void setName(String newName)
   {
      name=newName;
   }
   public void toKgs()
   {
      weight=weight*0.453592;
   }
   public String toString()
   {
      return ("Dog's Weight:"+weight+"\nDog's Name: "+name);
   }

}