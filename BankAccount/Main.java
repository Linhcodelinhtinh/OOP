package OOP.BankAccount;

public class Main {
    public static void main(String[] args) {
        Account me = new Gambler(100);

        me.deposit(100);
        me.withdraw(50);
        me.deposit(200);
        me.withdraw(50);
        me.endMonthCharge();
    }
}
