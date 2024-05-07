package OOP.BankAccount;

public class Fee extends Account {
    public Fee(int initialBalance) {
        super(initialBalance);
    }
    public void endMonthCharge(){
        balance -=5;
        super.endMonthCharge();
    }
}
