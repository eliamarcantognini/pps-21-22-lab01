package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccountWithAtm {

    private static final int ATM_FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    public void depositWithAtm(int userID, double amount) {
        if (checkUser(userID)) {
            var balance = getBalance();
            balance += (amount - ATM_FEE);
            setBalance(balance);
        }
    }

    @Override
    public void withdrawWithAtm(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount + ATM_FEE)) {
            var balance = getBalance();
            balance -= (amount + ATM_FEE);
            setBalance(balance);
        }
    }

}
