package customer;

import banking.models.Account;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String mobile;
    private String address;
    private static List<Account> accounts = new ArrayList<Account>();

    private static int identity = 0;

    public Customer(String name, String mobile, String address, Account account){
        this.id = ++identity;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.createAccount(account);
    }

    public void createAccount(Account account){
        accounts.add(account);
    }

    public static Account getAccountDetails(long accnum){
        for (Account account:accounts) {
            if(accnum == account.getAccountNumber()){
                return account;
            }
        }
        return null;
    }
}
