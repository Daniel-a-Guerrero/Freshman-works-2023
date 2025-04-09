// ************************************************************
// Guess.java
//
// Play a game where the user guesses a number from 1 to 10
//
// ************************************************************
import java.util.Scanner;
import java.util.Random;
public class Guess
{
public static void main(String[] args)
{
int numToGuess; //Number the user tries to guess
int guess; //The user's guess
Scanner scan = new Scanner(System.in);
Random generator = new Random();
numToGuess=generator.nextInt(10)+1;
System.out.println("Make a guess:");
guess=scan.nextInt();
while (guess!=numToGuess) 
 {
System.out.println("Guess is wrong. Guess again:");
guess=scan.nextInt();
}
System.out.println("Guess is right. Congratulations!");
}
}