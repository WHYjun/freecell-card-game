package bankaccountapp;

public class Saving extends Account {
    // List properties specific to a saving account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize saving account properties
    public Saving(String name, String SSN, double initDeposit){
        super(name, SSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    // List any methods specific to a saving account
    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println(
                "Your Saving Account Features" +
                "\n Safety Deposit Box ID" + safetyDepositBoxID +
                "\n Safety Deposit Box Key" + safetyDepositBoxKey
                );
    }

    @Override
    public void setRate(){
        rate = getBaseRate() * .25;
    }
}
