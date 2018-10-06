package emailapp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int passwordLength = 10;
    private String alternateEmail;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created: " + this.firstName + " " + this.lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Generate Email Address based on elements
        this.email = generateAddress();
        System.out.println("Your Email Address is " + this.email);

        // Call a method generating random password - return the department
        this.password = generatePassword(passwordLength);
        System.out.println("Password: " + this.password);
    }

    // Ask for the department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter the department: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        String dept;
        switch(deptChoice){
            case 1:
                dept = "Sales";
                break;
            case 2:
                dept = "Development";
                break;
            case 3:
                dept = "Accounting";
                break;
            default:
                dept =  "";
        }
        return dept;
    }
    // Generate a random password
    private String generatePassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@!#$";
        char[] password = new char[length];
        for(int i = 0; i < length; i++) {
            password[i] = passwordSet.charAt((int) (Math.random() * passwordSet.length()));
        }
        return new String(password);
    }

    // Generate an Email
    private String generateAddress(){
        String address = this.firstName + "." + this.lastName + "@" + this.department + ".xyz.org";
        return address.toLowerCase();
    }

    // Set methods
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String address){
        this.alternateEmail = address;
    }

    // Change the password
    public void changePassword(String newPassword){
        this.password = newPassword;
    }

    // Get methods (It's okay without this)
    public int getMailboxCapacity(){
        return this.mailboxCapacity;
    }

    public String getAlternateEmail(){
        return this.alternateEmail;
    }

    public String getPassword(){
        return this.password;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                " EMAIL ADDRESS: " + email + " MAILBOX CAPACITY: " +
                mailboxCapacity + "mb";
    }
}
