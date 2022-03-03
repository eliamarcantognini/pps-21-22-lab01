import lab01.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends SimpleBankAccountTest{

    private BankAccountWithAtm bankAccountWithAtm;
    @BeforeEach
    @Override
    void beforeEach(){
        setAccountHolder(new AccountHolder("Mario", "Rossi", 1));
        bankAccountWithAtm = new SimpleBankAccountWithAtm(getAccountHolder(), 0);
        setBankAccount(bankAccountWithAtm);
    }

    @Test
    void testDepositWithAtm() {
        bankAccountWithAtm.depositWithAtm(getAccountHolder().getId(), 100);
        assertEquals(99, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccountWithAtm.depositWithAtm(getAccountHolder().getId(), 100);
        bankAccountWithAtm.depositWithAtm(2, 50);
        assertEquals(99, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccountWithAtm.depositWithAtm(getAccountHolder().getId(), 100);
        bankAccountWithAtm.withdrawWithAtm(getAccountHolder().getId(), 70);
        assertEquals(28, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        bankAccountWithAtm.depositWithAtm(getAccountHolder().getId(), 100);
        bankAccountWithAtm.withdrawWithAtm(getAccountHolder().getId(), 70);
        bankAccountWithAtm.withdrawWithAtm(2, 50);
        assertEquals(28, bankAccountWithAtm.getBalance());

    }
}
