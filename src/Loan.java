public class Loan {



    private String loanType;
    private double interestRate;
    private int amount;

    public Loan(){

        this.loanType = "Personal loan";
        this.interestRate = 4;
        this.amount = 0;

    }

    public Loan(String loanType, int amount){

        this.loanType = loanType;

        if (loanType == "House mortgage") { this.interestRate = 1; }
        else if (loanType == "Car loan") { this.interestRate = 3; }
        else { this.interestRate = 4; } // Personal loan

        this.amount = amount;

    }

    public double getInterestRate() { return this.interestRate; }

    public int getAmount() {return this.amount;}

    public String getLoanType() {return this.loanType;}

    public void setLoanType(String loanType) {

        if (loanType != "House mortgage" && loanType != "Car loan" && loanType != "Personal loan") {

            throw new IllegalArgumentException("loanType must be 'House mortgage', 'Car loan', or 'Personal loan'");

        }

        if (loanType == "House mortgage") { this.interestRate = 1; }
        else if (loanType == "Car loan") { this.interestRate = 3; }
        else { this.interestRate = 4; } // Personal loan

        this.loanType = loanType;

    }

    public void setAmount(int amount) {

        if (amount <= 0 || amount > 300000) {

            throw new IllegalArgumentException("Amount must be greater than 0 and no more than 300000");

        }

        this.amount = amount;

    }



    // return String representation of Loan object
    @Override

    public String toString() {

        return String.format("Loan type: {0}, Interest rate: {1}, Amount: {2}", this.loanType, this.interestRate, this.amount);

    }

}
