import java.util.Scanner;

public class CyrillicConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to convert to Cyrillic: ");
        String input = scanner.nextLine().toUpperCase();
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case 'A':
                    output += "Д";
                    break;
                case 'B':
                    output += "Б";
                    break;
                case 'C':
                    output += "Ц";
                    break;
                case 'D':
                    output += "Д";
                    break;
                case 'E':
                    output += "Е";
                    break;
                case 'F':
                    output += "Ф";
                    break;
                case 'G':
                    output += "Г";
                    break;
                case 'H':
                    output += "Х";
                    break;
                case 'I':
                    output += "И";
                    break;
                case 'J':
                    output += "Ј";
                    break;
                case 'K':
                    output += "К";
                    break;
                case 'L':
                    output += "Л";
                    break;
                case 'M':
                    output += "М";
                    break;
                case 'N':
                    output += "Н";
                    break;
                case 'O':
                    output += "О";
                    break;
                case 'P':
                    output += "П";
                    break;
                case 'Q':
                    output += "К";
                    break;
                case 'R':
                    output += "Р";
                    break;
                case 'S':
                    output += "Ѕ";
                    break;
                case 'T':
                    output += "Т";
                    break;
                case 'U':
                    output += "У";
                    break;
                case 'V':
                    output += "В";
                    break;
                case 'W':
                    output += "Ш";
                    break;
                case 'X':
                    output += "КС";
                    break;
                case 'Y':
                    output += "Ј";
                    break;
                case 'Z':
                    output += "З";
                    break;
                case ' ':
                    output += " ";
                    break;
                default:
                    output += c;
            }
        }

        System.out.println("Cyrillic conversion: " + output);
    }
}