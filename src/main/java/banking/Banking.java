package banking;

import banking.models.Account;
import banking.models.Transaction;
import customer.Customer;
import exceptions.InsufficientFundsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Banking implements IAccount{
    Scanner scanner = new Scanner(System.in);
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public double checkBalance(long accnum){
        Account account = Customer.getAccountDetails(accnum);
        return account.getBalance();
    }

    protected void creditMoney(long accnum, double amount){
        Account account = Customer.getAccountDetails(accnum);
        if(amount > 0 && account != null){
            account.setBalance(account.getBalance() + amount);
            this.setTransaction(0, amount);
        }
    }


    protected void debit(long accnum, double wAmount) throws InsufficientFundsException{
        Account account = Customer.getAccountDetails(accnum);
        if(wAmount > 0 && account != null){
            if(account.getBalance() > wAmount) {
                account.setBalance(account.getBalance() - wAmount);
                this.setTransaction(1, wAmount);
                System.out.println("Withdraw Successful");
            }else{
                throw new InsufficientFundsException();
            }
        }else {
            System.out.println("Withdraw unsuccessful");
        }
    }

    protected void transferMoneytoAccount(long accnum, long pAccnum, double wAmount) throws InsufficientFundsException{
        Account account = Customer.getAccountDetails(accnum);
        Account payeeAccount = Customer.getAccountDetails(pAccnum);
        if(account != null && payeeAccount != null) {
            if(account.getBalance() < wAmount){
                throw new InsufficientFundsException();
            }
            account.setBalance(account.getBalance() - wAmount);
            this.setTransaction(1,wAmount);
            payeeAccount.setBalance(payeeAccount.getBalance() + wAmount);
            this.setTransaction(0,wAmount);
        }
        System.out.println("Transfer Successful");
    }
    public List<Transaction> getTransactions(){
        return transactions;
    }

    public void setTransaction(int type, double amount){
        Transaction transaction = new Transaction(type, amount);
        transactions.add(transaction);
    }
}
