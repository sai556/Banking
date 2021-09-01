package banking;

import exceptions.InsufficientFundsException;

public class BankingAccount extends  Banking{
    public BankingAccount(){
        super();
    }

    public void Deposit(long accnum, double amount) {
        this.creditMoney(accnum, amount);
    }

    public  void WithDraw(long accnum, double amount) throws InsufficientFundsException {
        this.debit(accnum, amount);
    }

    public void FundsTransfer(long accnum, long pAccnum, double wAmount) throws InsufficientFundsException{
        this.transferMoneytoAccount(accnum, pAccnum, wAmount);
    }
}
