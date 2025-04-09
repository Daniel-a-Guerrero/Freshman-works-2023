public class Driver
{
   public static void main(String[] args)
   {
      Die die1=new Die();
      Die die2=new Die();
      die1.roll();
      int cnt=0;
      die2.roll();
      do{if(die1.getFaceValue()%2==1 && die2.getFaceValue()%2==1){cnt++;}die1.roll();die2.roll();}while(!(die1.equals(die2)));
/*      while(!die1.equals(die2))
      {
      if(die1.getter()%2==1&&die2.getter()%2==1)
         {
         cnt++;
         }
      die1.roll();die2.roll();
      }*/
//    die1.equalTo(die2);
//    if (die1.equalTo(die2))
//    {System.out.println("equal");}
//    else
//    System.out.println("not equal");
//    int x=die1.compareTo(die2);
//    if (x==1)
//       System.out.println("Die1 bigger facev");
   }
}