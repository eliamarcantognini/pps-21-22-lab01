package lab01.example.model;

public interface BankAccountWithAtm extends BankAccount{

    /**
     * Allows the deposit of an amount on the account within an ATM, if the given userID corresponds
     *  to the register holder ID of the bank account. This ID acts like an "identification token" .
     *
     * @param userID the id of the user that wants do the deposit
     * @param amount the amount of the deposit
     */
    void depositWithAtm(int userID, double amount);
}
