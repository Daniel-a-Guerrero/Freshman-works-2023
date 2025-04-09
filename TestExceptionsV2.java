import java.util.*;
public class TestExceptionsV2
{
   public static void main (String[] args)
   {
      String name,address,phone,ssn;
      double rate, totalPay=0.0;
      int validEmployees = 0;
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
         validEmployees++;
         totalPay += hList[i].pay();
         }
         catch (NoOvertimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Hours worked set to 0 for this employee");
                Hourly employee = new Hourly(name, address, phone, ssn, rate);
                employee.addHours(0);
                hList[i] = employee;
            }
        }

        System.out.println("\nTotal number of hourly employees with valid hours worked: " + validEmployees);
        System.out.println("Average pay for hourly employees: " + (totalPay / validEmployees));
   }
}