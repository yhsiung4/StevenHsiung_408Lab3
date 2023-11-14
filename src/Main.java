import java.text.MessageFormat;
import java.util.*;

public class Main {

    public static List<Loan> listOfLoans = new ArrayList<Loan>();

    public static void main(String[] args) {

        boolean appExit = false;

        Scanner scanner = new Scanner(System.in);

        do{

            System.out.println("   1.  Disburse a Loan\n   2.  Show the list of all loans\n   3.  Show sum of all loans\n   4.  Exit\n");
            int option1 = scanner.nextInt();

            switch (option1){

                case 1:
                    // Disburse a loan
                    boolean optExit = false;

                    System.out.print("\n\n");

                    do{

                        System.out.println("Select the loan type:\n   1.  House mortgage\n   2.  Car loan\n   3.  Personal loan\n");
                        int option2 = scanner.nextInt();

                        System.out.print("\n\n");

                        switch (option2){

                            case 1:
                                // House mortgage
                                createLoan("House mortgage");

                                optExit = true;

                                break;
                            case 2:
                                // Car loan
                                createLoan("Car loan");

                                optExit = true;

                                break;
                            case 3:
                                // Personal loan
                                createLoan("Personal loan");

                                optExit = true;

                                break;
                            default:
                                // House mortgage
                                System.out.println("Invalid option");
                                break;

                        }

                    } while (!optExit);


                    break;
                case 2:
                    // Show List

                    System.out.format( "\n%-14s  %-6s  %-6s", "Type", "Amount", "Amount owed" );
                    if (listOfLoans.size() > 0) {

                        for (Loan loan : listOfLoans){

                            System.out.format( "\n%-14s  %-6s  %-6s",
                                    loan.getLoanType(),
                                    "$" + loan.getAmount(),
                                    "$" + (int)( loan.getAmount() * ( 1 + ( loan.getInterestRate() / 100 ) ) ) );

                        }

                    }
                    else {

                        System.out.println("no loans");

                    }

                    System.out.print("\n\n");

                    break;
                case 3:


                    System.out.format( "\n%-6s   %-6s", "Amount", "Amount owed" );

                    if (listOfLoans.size() > 0) {

                        int amount = 0;
                        int amountOwed = 0;

                        for (Loan loan : listOfLoans){

                            amount += loan.getAmount();
                            amountOwed += (int)( loan.getAmount() * ( 1 + ( loan.getInterestRate() / 100 ) ) );

                        }

                        System.out.format( "\n%-6s  %-6s", "$" + amount, "$" + amountOwed );

                    }
                    else {

                        System.out.println( "no loans" );

                    }

                    System.out.print("\n\n");

                    break;
                case 4:
                    // Exit
                    appExit = true;
                    break;
                default:

                    break;

            }

        } while (!appExit);

    }

    public static void createLoan(String loanType){

        Scanner scanner = new Scanner(System.in);

        Loan newLoan = new Loan(loanType, 0);
        System.out.println(MessageFormat.format("Starting a new {0}. Current interest rate {1}%", loanType, newLoan.getInterestRate()));
        System.out.print(String.format("Enter the amount of the loan: "));
        int amount = scanner.nextInt();

        newLoan.setAmount(amount);

        listOfLoans.add(newLoan);

        System.out.println("Loan disbursed\n\n");

    }

}