import java.util.Scanner;
import java.util.Random;
public class RandomNumbers
{
    public static void main (String[] args)
    {
        Scanner scan=new Scanner(System.in);
        Random generator=new Random();
        int die=generator.nextInt(6)+1;
        System.out.println("Die 1: "+die);
        int die2=generator.nextInt(6)+1;
        System.out.println("Die 2: "+die2);
        System.out.println("Die sum: "+(die+die2));
    }
}