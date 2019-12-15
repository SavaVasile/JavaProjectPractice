package bankaccountapp;

public class Checking extends Account {
    //List proprietes  specific to a Checking accounts
    private long debitCardNumber;
    private int debitCartPin;

    //Constr to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();

    }

    private void setDebitCard() {
        debitCardNumber = (long) (Math.random() * Math.pow(10, 16));
        debitCartPin = (int) (Math.random() * Math.pow(10, 4));
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    //List any methods specific to the checking acc
    public void showInfo() {
        super.showInfo();
        System.out.println(" Your Checking Account Features: " +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card Pin: " + debitCartPin
        );
    }


}
