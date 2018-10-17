package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args){
        // Read a csv file then create new accounts based on that data
        /*
        Checking chkAccount1 = new Checking("John Smith", "782983788", 1500.0);

        Saving savAccount1 = new Saving("Jane Smith", "738729389", 3000.0);

        chkAccount1.showInfo();
        savAccount1.showInfo();
        */
        List<Account> accounts = new LinkedList<>();
        String file = "/home/youngchoi/Documents/github/java-projects/src/bankaccountapp/NewBankAccounts.csv";
        List<String[]> newCustomers = utilities.CSV.read(file);
        for(String[] customer : newCustomers){
            String name = customer[0];
            String SSN = customer[1];
            String accountType = customer[2];
            double deposit = Double.parseDouble(customer[3]);
            if(accountType.equals("Checking")){
                Checking account = new Checking(name, SSN, deposit);
                accounts.add(account);
            }
            else{
                Saving account = new Saving(name, SSN, deposit);
                accounts.add(account);
            }
        }

        for(Account acc : accounts){
            System.out.println("******************");
            acc.showInfo();
        }
    }
}
