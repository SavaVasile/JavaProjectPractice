package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        /*Checking chkacc1 = new Checking("Tom Wilson","32456879",1500);

        Savings savacc1 = new Savings("Mitch Low","456657897",2500);
        savacc1.compound();
        chkacc1.showInfo();
        System.out.println("**************************************");
        savacc1.showInfo();
        */

        List<Account> accounts = new LinkedList<>();

        //Read CSV file then create new accounts based on that data
        String file = "C:\\Users\\VaS\\Downloads\\NewBankAccounts.csv";
        List<String []> newAccountHolders = utilities.CSV.read(file);
        for (String [] accountHolder : newAccountHolders){
                String name = accountHolder[0];
                String sSN = accountHolder[1];
                String accountType = accountHolder[2];
                double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")){
                accounts.add(new Savings(name,sSN,initDeposit));
            }else if (accountType.equals("Checking")){
                accounts.add(new Checking(name,sSN,initDeposit));
            }else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }
        for (Account acc : accounts){
            System.out.println("\n***********************");
            acc.showInfo();
        }
    }
}
