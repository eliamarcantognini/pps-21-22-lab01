package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccountWithAtm {

    private static final int ATM_FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    public void depositWithAtm(int userID, double amount) {
        if (checkUser(userID)) {
            this.balance += (amount - ATM_FEE);
        }
    }

    @Override
    public void withdrawWithAtm(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount + ATM_FEE)) {
            this.balance -= (amount + ATM_FEE);
        }
    }

}
