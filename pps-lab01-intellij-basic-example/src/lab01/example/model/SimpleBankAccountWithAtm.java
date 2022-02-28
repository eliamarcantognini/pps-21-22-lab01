package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccountWithAtm {

    private static final int ATM_FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    public void depositWithAtm(int userID, double amount) {
        if (userID == holder.getId()) {
            this.balance += amount - ATM_FEE;
        }
    }
}
