import java.util.Scanner;
import java.util.Random;
public class LabWeek3
{
    public static void main (String[] args)
    {
        Scanner scan=new Scanner(System.in);
        Random generator=new Random();
        int a=generator.nextInt(6);
        int i=10;
        while (i>=0){
        System.out.println(generator.nextInt(6));
        i=-1;
        }
    }
}