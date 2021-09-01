package banking.models;

import java.util.Date;

public class Transaction {
    private int id;
    private TransactionType type;
    private Date date;
    private Double amount;

    private static int identity = 0;

    public Transaction(int type, Double amount) {
        Date date = new Date();

        this.id = ++identity;
        this.type = (type == 0) ? TransactionType.CREDIT : TransactionType.DEBIT;
        this.date = date;
        this.amount = amount;
    }
}
enum TransactionType{
    CREDIT, DEBIT
}
