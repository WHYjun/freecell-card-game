package bankaccountapp;

public interface IBaseRate {
    // Write a method that returns the IBaseRate
    default double getBaseRate(){
        return 2.5;
    }
}
