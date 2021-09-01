package banking.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private long accountNumber;
    private AccountType accountType;
    private double balance;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    private static int identity = 0;
    private static int accIncrementNumber = 1200;

    public Account(int type) {
        this.id = ++identity;
        this.accountNumber = ++accIncrementNumber;
        this.accountType = (type==0) ? AccountType.SAVINGS : AccountType.CURRENT;
        this.balance = 0.00;
    }

    public long getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(Double balance){
        this.balance = balance;
    }

}
enum AccountType{
    SAVINGS, CURRENT
}