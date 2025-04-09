import java.util.*;
public class TestExceptionsV1
{
   public static void main (String[] args)
   {
      String name,address,phone,ssn;
      double rate;
      int hours;
      Scanner scan=new Scanner(System.in);
      System.out.println("How many hourlies?");
      int hrl=scan.nextInt();
      Hourly[] hList=new Hourly[hrl];
      for(int i=0;i<hrl;i++)
      {
         System.out.println("Enter name:");
         scan.nextLine();
         name=scan.nextLine();
         System.out.println("Enter address:");
         address=scan.nextLine();
         System.out.println("Enter phone number:");
         phone=scan.nextLine();
         System.out.println("Enter social security number:");
         ssn=scan.nextLine();
         System.out.println("Enter rate:");
         rate=scan.nextDouble();
         System.out.println("Enter hours:");
         hours=scan.nextInt();
         try{
         if(hours>40) throw new NoOvertimeException("Employee can't work for more than 40 hours");
         hList[i]=new Hourly(name,address,phone,ssn,rate);
         hList[i].addHours(hours);
         }
         catch (NoOvertimeException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        for (int i = 0; i < hrl; i++) {
            System.out.println(hList[i].toString());
            System.out.println("Pay: $" + hList[i].pay());
            System.out.println();
        }
   }
}