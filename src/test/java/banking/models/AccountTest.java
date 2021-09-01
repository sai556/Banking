package banking.models;

import customer.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;
    List<Transaction> transactions = new ArrayList<Transaction>();
    Customer customer;

    @BeforeEach
    void setUp() {
        Account account = new Account(0);
        customer = new Customer("Test one", "9898989898", "address 1", account);
    }

    @Test
    void getAccountNumber() {
        account = new Account(0);
        customer = new Customer("Test one", "9898989898", "address 1", account);
        assertEquals(account, Customer.getAccountDetails(account.getAccountNumber()));
    }


    @Test
    void getBalance() {
        account = new Account(0);
        customer = new Customer("Test two", "9898989898", "address 1", account);
        assertEquals(0.00, account.getBalance());
    }

    @Test
    void setBalance() {
        account = new Account(0);
        customer = new Customer("Test two", "9898989898", "address 1", account);
        double balance = account.getBalance();
        account.setBalance(1000.00);
        assertEquals(balance+1000.00,account.getBalance());
    }

    @AfterEach
    void tearDown() {
        customer = null;
    }
}