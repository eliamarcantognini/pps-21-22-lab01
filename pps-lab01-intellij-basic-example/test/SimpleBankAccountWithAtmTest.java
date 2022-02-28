import lab01.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends SimpleBankAccountTest{

    private BankAccountWithAtm bankAccountWithAtm;
    @BeforeEach
    @Override
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccountWithAtm = new SimpleBankAccountWithAtm(accountHolder, 0);
        bankAccount = bankAccountWithAtm;
    }

    @Test
    void testDepositWithAtm() {
        bankAccountWithAtm.depositWithAtm(accountHolder.getId(), 100);
        assertEquals(99, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccountWithAtm.depositWithAtm(accountHolder.getId(), 100);
        bankAccountWithAtm.depositWithAtm(2, 50);
        assertEquals(99, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccountWithAtm.depositWithAtm(accountHolder.getId(), 100);
        bankAccountWithAtm.withdrawWithAtm(accountHolder.getId(), 70);
        assertEquals(28, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        bankAccountWithAtm.depositWithAtm(accountHolder.getId(), 100);
        bankAccountWithAtm.withdrawWithAtm(accountHolder.getId(), 70);
        bankAccountWithAtm.withdrawWithAtm(2, 50);
        assertEquals(28, bankAccountWithAtm.getBalance());

    }
}
