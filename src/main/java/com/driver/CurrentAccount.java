package com.driver;

import java.util.ArrayList;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
          super(name,balance);
          this.tradeLicenseId = tradeLicenseId;
          try{
              double bal = getBalance();
              if(bal<5000){
                  throw new Exception("Insufficient Balance");
              }
          }catch(Exception e){
              e.getMessage();
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean isvalid = true;
        String s = tradeLicenseId;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                isvalid = false;
                break;
            }
        }
        if(isvalid == false){
            ArrayList<String> st = new ArrayList<>();
            generatePermutations(s,st,"");
            int t = st.size();
            for(int i=0;i<t;i++){
                String str = st.get(i);
                isvalid = true;
                for(int j=1;j<str.length();j++){
                    if(s.charAt(i)==s.charAt(i-1)){
                        isvalid = false;
                    }
                }
                if(isvalid == true){
                    break;
                }
            }
        }
        try{
            if(isvalid == false){
              throw new Exception("Valid License can not be generated");
            }
        }catch(Exception e){
            e.getMessage();
        }

    }
    public void generatePermutations(String s,ArrayList<String> st,String ans){
        if(s.length()==0){
            st.add(ans);
            return;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            String ros = s.substring(0,i)+s.substring(i+1);
            generatePermutations(ros,st,ans+ch);
        }
    }

}
