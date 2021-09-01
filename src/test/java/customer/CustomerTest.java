package customer;

import banking.models.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;
    private List<Account> accounts = new ArrayList<Account>();

    @BeforeEach
    void setUp() {
        Account account = new Account(0);
        customer = new Customer("Test one", "9898989898", "address 1", account);
    }


    @Test
    void createAccount() {
        Account account = new Account(0);
        customer = new Customer("Test one", "9898989898", "address 1", account);
        assertEquals(account, Customer.getAccountDetails(account.getAccountNumber()));
    }

    @Test
    void createCurrentAccount() {
        Account account = new Account(1);
        customer = new Customer("Test one", "9898989898", "address 1", account);
        assertEquals(account, Customer.getAccountDetails(account.getAccountNumber()));
    }

    @Test
    void createAccountwithNegative(){
        assertNull(Customer.getAccountDetails(1000));
    }


//multiple assertions to create an customer like name, mobile, address, typeofaccount

    @AfterEach
    void tearDown() {
        customer = null;
    }
}