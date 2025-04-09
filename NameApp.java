import java.util.Scanner;
public class NameApp
{
    public static void main (String[] args)
    {
        Scanner scan=new Scanner(System.in);
        String FName=scan.nextLine();
        String LName=scan.nextLine();
        String FInitial=FName.substring(0,1);
        String LInitial=LName.substring(0,1);
        System.out.println("Initials: "+FInitial+LInitial);
        double FLength=FName.length();
        double LLength=LName.length();
        double NameAverage=((FLength+LLength)/2);
        System.out.println("Average Length: "+NameAverage);
    }
}