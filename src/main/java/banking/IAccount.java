package banking;

import exceptions.InsufficientFundsException;

public interface IAccount {
    void Deposit(long accnum, double amount);
    void WithDraw(long accnum, double amount) throws InsufficientFundsException;
    void FundsTransfer(long accnum, long pAccnum, double wAmount) throws InsufficientFundsException;
}