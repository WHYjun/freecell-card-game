package bankaccountapp;

public abstract class Account implements IBaseRate {
    // List common properties for savings and checking accounts
    String name;
    String SSN;
    double balance;
    static int index = 10000;
    protected String accountNumber;
    protected double rate;

    // Constructor to set base properties and initialize accounts
    public Account(String name, String SSN, double initDeposit){
        this.name = name;
        this.SSN = SSN;
        balance = initDeposit;

        // Set account number
        index++;
        accountNumber = setAccountNumber();

        setRate();
    }

    private String setAccountNumber(){
        String lastTwoOfSSN = SSN.substring(SSN.length() - 3, SSN.length());
        int uniqueID = index;
        int randomNumber = (int) (1000 * Math.random());
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    // List common methods
    public void showInfo(){
        System.out.println(
                "Name: " + name +
                "\nAccount Number: " + accountNumber +
                "\nBalance: " + balance +
                "\nRate: " + rate + "%"
        );
    }

    public abstract void setRate();

    public void compoundInterest(){
        double accruedInterest = balance * (rate/100);
        System.out.println("Accrued Interest is $" + accruedInterest);
        balance += accruedInterest;
        printBalance();
    }

    public void deposit(double amount){
        balance += amount;
        printBalance();
    }

    public void withdraw(double amount){
        balance -= amount;
        printBalance();
    }

    public void transfer(String toWhere, double amount){
        balance -= amount;
        System.out.println("Transfer " + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is $" + balance);
    }
}
