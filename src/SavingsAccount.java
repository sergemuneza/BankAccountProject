/*Name: Serge MUNEZA
Reg. No.: 20248/2022
Class name: SavingAccount..
 */
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(BankAccount account, double interestRate) {
        super(account.getAccountNumber(), account.getAccountHolderName(), account.getBalance());
        this.interestRate = interestRate;
    }

    // Method to apply interest
    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        updateBalance(interest); // Add interest directly to balance
        System.out.println("Interest of " + interest + " applied. New balance: " + getBalance());
    }

    // Display account details with interest rate
    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
