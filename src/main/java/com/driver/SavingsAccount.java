package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
       super(name,balance);
       super.setMinBalance(0);
       this.maxWithdrawalLimit = maxWithdrawalLimit;
       this.rate = rate;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        try{
            if(amount <= maxWithdrawalLimit){
                double balance = getBalance() - amount;
                setBalance(balance);
            }
            else{
                throw new Exception("Maximum Withdraw Limit Exceed");
            }
        }catch(Exception e){
            e.getMessage();
        }
        try{
            if(getBalance()>=amount){
                double balance = getBalance() - amount;
                setBalance(balance);
            }
            else{
                throw new Exception("Insufficient Balance");
            }
        }catch(Exception e){
           e.getMessage();
        }

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double z = getBalance();
        double ans = (z*years*rate)/100;
        return ans+z;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double z = getBalance();
        int dummy = 0;
        while(years!=0){
            dummy = (int) (dummy * (1+rate/times));
            years--;
        }
        double ans = z*dummy;
        return ans;
    }

}
