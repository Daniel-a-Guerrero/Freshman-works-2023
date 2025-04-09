public class Workshop {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter loan amount: ");
        double loanAmt = scan.nextDouble();
        System.out.println("Enter annual interest rate (%): ");
        double intRate = scan.nextDouble() / 100; // Convert percentage to decimal
        System.out.println("Enter number of years: ");
        int years = scan.nextInt();
        
        double totalPayment = calculateTotalPayment(loanAmt, intRate, years);
        System.out.println("You will have to pay $" + df.format(totalPayment));
        
        scan.close();
    }

    public static double calculateTotalPayment(double loanAmt, double intRate, int years) {
        double monthlyRate = intRate / 12;
        int months = years * 12;
        double monthlyPayment = (loanAmt * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
        return monthlyPayment * months;
    }
}