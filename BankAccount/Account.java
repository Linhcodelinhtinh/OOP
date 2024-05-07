package OOP.BankAccount;

public abstract class Account {
    protected double balance;
    protected int withdrawals;
    protected int deposits;
    public Account(int initialBalance) {
        balance = initialBalance;
        withdrawals = 0;
        deposits = 0;
    }
    public void deposit(int amount) {
        balance += amount;
        deposits++;
    }
    public void withdraw(int amount) {
        balance -= amount;
        withdrawals++;
    }
    public void endMonthCharge(){
        System.out.println("Your balance: " + balance);
        System.out.println("Your transactions: " + (withdrawals+deposits));

        withdrawals = 0;
        deposits = 0;

    }
}
