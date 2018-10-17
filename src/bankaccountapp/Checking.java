package bankaccountapp;

public class Checking extends Account {
    // List properties specific to a checking account
    private int debitCardNumber;
    private int debitCardPin;

    // Constructor to initialize checking account properties
    public Checking(String name, String SSN, double initDeposit){
        super(name, SSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    private void setDebitCard(){
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }

    // List any methods specific to a checking account
    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("Your Checking Account Feature:" +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card Pin: " + debitCardPin);
    }

    @Override
    public void setRate(){
        rate = getBaseRate() * .15;
    }
}
