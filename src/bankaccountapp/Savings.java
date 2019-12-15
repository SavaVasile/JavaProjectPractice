package bankaccountapp;

public class Savings extends Account {
    //List propr specific to the Savings acc
    private int safetyDepositBoxId;
    private int safetyDepositBoxKey;


    //Constr t init settings for the Savings propr
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber= "1" + accountNumber;
        setSafetyDepositBox();

    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxId = (int) (Math.random()* Math.pow(10,3));
        safetyDepositBoxKey =(int) (Math.random()* Math.pow(10,4));

    }



    //List any ethods specific to the Savings account
    public void showInfo(){
        super.showInfo();
        System.out.println(
                " Your Savings Account Features: "+
                        "\n Safety Deposit Box ID: "+ safetyDepositBoxId+
                        "\n Safety Deposit Box Key: " + safetyDepositBoxKey
        );

    }



}
