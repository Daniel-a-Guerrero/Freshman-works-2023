import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean fileExists = false;
        Scanner fileScanner = null;

        while (!fileExists) {
            System.out.print("Enter a filename: ");
            String filename = input.nextLine();
            try {
                File file = new File(filename);
                fileScanner = new Scanner(file);
                fileExists = true;
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
            }
        }

        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }

        fileScanner.close();
    }
}