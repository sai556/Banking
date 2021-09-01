package banking;

import banking.models.Account;
import banking.models.Transaction;
import customer.Customer;
import exceptions.InsufficientFundsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankingAccountTest {

    private Customer customer;
    private Account account;
    private BankingAccount bankingAccount = new BankingAccount();
    private List<Transaction> transactions = new ArrayList<Transaction>();

    @BeforeEach
    void setUp() {
        account = new Account(0);
        customer = new Customer("Test one", "9898989898", "address 1", account);
    }

    @Test
    void deposit() {
        bankingAccount.Deposit(account.getAccountNumber(),1000.00);
        assertEquals(1000.00, bankingAccount.checkBalance(account.getAccountNumber()));
    }

    @Test
    void depositWithNegativeCase() {
        bankingAccount.Deposit(account.getAccountNumber(),1000.00);
        assertEquals(1000.00, bankingAccount.checkBalance(account.getAccountNumber()));
    }

    @Test
    void withDraw() throws InsufficientFundsException {
        bankingAccount.Deposit(account.getAccountNumber(),1000.00);
        bankingAccount.WithDraw(account.getAccountNumber(), 500.00);
        assertEquals(500.00, bankingAccount.checkBalance(account.getAccountNumber()));
    }

    @Test
    void withDrawWithInsufficientFunds() {
        bankingAccount.Deposit(account.getAccountNumber(),1000.00);
        assertThrows(InsufficientFundsException.class,
                ()->bankingAccount.WithDraw(account.getAccountNumber(), 1500.00));
    }

    @Test
    void fundsTransfer() throws InsufficientFundsException{
        Account account1 = new Account(0);
        Customer customer1 = new Customer("Test two", "9898989898", "address two", account1);
        bankingAccount.Deposit(account.getAccountNumber(),1000.00);
        bankingAccount.FundsTransfer(account.getAccountNumber(), account1.getAccountNumber(), 500);
        assertAll(()-> {
            assertEquals(500, bankingAccount.checkBalance(account.getAccountNumber()));
            assertEquals(500, bankingAccount.checkBalance(account1.getAccountNumber()));
        });
    }

    @Test
    void fundsTransferWithInsufficient(){
        Account account1 = new Account(0);
        Customer customer1 = new Customer("Test two", "9898989898", "address two", account1);
        bankingAccount.Deposit(account.getAccountNumber(),1000.00);
        assertThrows(InsufficientFundsException.class, ()->bankingAccount.FundsTransfer(account.getAccountNumber(), account1.getAccountNumber(), 1500));

    }

    @Test
    void getStatement() throws InsufficientFundsException{
        bankingAccount.Deposit(account.getAccountNumber(),1000.00);
        bankingAccount.WithDraw(account.getAccountNumber(), 500.00);
        assertNotNull(bankingAccount.getTransactions());
    }
}