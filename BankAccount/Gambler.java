package OOP.BankAccount;

import java.util.Random;

public class Gambler extends Account{
    private Random rand = new Random();
    public Gambler(int initialBalance) {
        super(initialBalance);
    }
    public void withdraw(int amount) {
        double chance = rand.nextDouble();
        if (chance < 0.5) {
            balance = balance - amount;
            System.out.println("You win the gamble");
        }
        else {
            balance -= amount * 2;
            System.out.println("You lost the gamble");
        }
        withdrawals++;
    }

}
