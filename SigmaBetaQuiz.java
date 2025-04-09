import java.util.Scanner;

public class SigmaBetaQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rickScore = 0;
        int jerryScore = 0;

        System.out.println("Welcome to the Sigma Male Rick and Beta Male Jerry Quiz!");
        System.out.println("Please answer the following questions with a 'yes' or 'no'.");
        System.out.println();

        // Question 1
        System.out.println("Question 1: Do you conform to traditional social norms?");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("no")) {
            rickScore++;
        } else {
            jerryScore++;
        }

        // Question 2
        System.out.println("Question 2: Do you often rely on others to make decisions for you?");
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            jerryScore++;
        } else {
            rickScore++;
        }

        // Question 3
        System.out.println("Question 3: Are you willing to take risks and confront difficult situations?");
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            rickScore++;
        } else {
            jerryScore++;
        }

        // Question 4
        System.out.println("Question 4: Do you often struggle with change and uncertainty?");
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            jerryScore++;
        } else {
            rickScore++;
        }

        // Determine result
        System.out.println();
        if (rickScore > jerryScore) {
            System.out.println("Congratulations! You exhibit more characteristics of a Sigma Male Rick.");
        } else if (jerryScore > rickScore) {
            System.out.println("Congratulations! You exhibit more characteristics of a Beta Male Jerry.");
        } else {
            System.out.println("It looks like you exhibit characteristics of both a Sigma Male Rick and a Beta Male Jerry.");
        }
    }
}