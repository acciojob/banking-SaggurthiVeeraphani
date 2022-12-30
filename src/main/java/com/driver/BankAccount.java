package com.driver;

public class BankAccount {

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
            this.name = name;
            this.balance = balance;
            this.minBalance = minBalance;
    }
    public BankAccount(String name,double balance){
        this.name = name;
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        try {
            int addsum = 0;
            while (digits > 0) {
                int x = digits % 10;
                addsum = addsum + x;
                digits = digits / 10;
            }
            if (addsum != sum) {
                throw new Exception("Account Number can not be generated");
            }
        }
        catch(Exception e){
           e.getMessage();
        }
        return null;
    }

    public void deposit(double amount) {
        balance = balance + amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
       try{
         if(balance-amount >= getMinBalance()){
             balance = balance - amount;
         }
         else{
             throw new Exception("Insufficient Balance");
         }
       }
       catch(Exception e){
           e.getMessage();
        }
    }

}