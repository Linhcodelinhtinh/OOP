package OOP.BankAccount;

public class NicklenDime extends Account{
    public NicklenDime(int initialBalance) {
        super(initialBalance);
    }
    public void endMonthCharge(){
        balance = balance - withdrawals * 0.5;
        super.endMonthCharge();
    }
}
