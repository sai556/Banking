import banking.BankingAccount;
import banking.models.Account;
import exceptions.InsufficientFundsException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InsufficientFundsException {
        System.out.println("****** Welcome to the your Banking app ******");
        Scanner scanner = new Scanner(System.in);
        BankingAccount savingsAccount = new BankingAccount();

        int input;
        do{
            System.out.println("Choose one of the following transactions:");
            System.out.println("1. Press 1 to Create an account");
            System.out.println("2. Press 2 to Check Balance");
            System.out.println("3. Press 3 to Transfer money");
            System.out.println("4. Press 4 to Withdraw money");
            System.out.println("5. Press 5 for Mini Statement");
            System.out.println("6. Press 6 to deposit");
            System.out.println("7. Press 7 to Exit");
            input = scanner.nextInt();
            switch(input){
                case 1: System.out.println("*** Create an account ***");
                    break;
                case 2: System.out.println("Check Balance");
                    long accnum = scanner.nextLong();
                    savingsAccount.checkBalance(accnum);
                    break;
                case 3: System.out.println("Funds Transfer");
                    long transferAccNum = scanner.nextLong();
                    long payeeAccNum = scanner.nextLong();
                    double tAmount = scanner.nextDouble();
                    savingsAccount.FundsTransfer(transferAccNum, payeeAccNum, tAmount);
                    break;
                case 4: System.out.println("Withdraw Money");
                    long account = scanner.nextLong();
                    double wAmount = scanner.nextDouble();
                    savingsAccount.WithDraw(account, wAmount);
                    break;
                case 5: System.out.println("Mini Statement");
                    long acc = scanner.nextLong();
//                    savingsAccount.getStatement(acc);
                    break;
                case 6: System.out.println("Deposit");
                    long accountNUmber = scanner.nextLong();
                    double amount = scanner.nextDouble();
                    savingsAccount.Deposit(accountNUmber,amount);
                    break;
                default: System.out.println("Thank you! Please visit again");
                    break;
            }
        } while(input < 7);
    }
}
