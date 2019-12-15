package bankaccountapp;

public abstract class Account implements IBaseRate { //abstract because we don t want to create objects of type Account
    // but we can create objects of classes that inherit Account


    // List common properties for savings and checking accounts
    private String name;
    private String sSN;//social security number
    private double balance;
    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    //Constr to set base prop and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;


        //set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate(); // not defining anything but forcing classes the inherit Account class
    //to implement the abstract method

    private String setAccountNumber() {
        String lastTwonOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwonOfSSN + uniqueID + randomNumber;
    }
    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        showBalance();
    }

    //List common methods - transactions
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        showBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        showBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        showBalance();
    }

    public void showBalance() {
        System.out.println("Your balance is now: " + balance);

    }

    public void showInfo() {
        System.out.println(
                "NAME: " + name +
                        "\nACCOUNT NUMBER: " + accountNumber +
                        "\nBALANCE: " + balance +
                        "\nRATE: " + rate + "%"
                //                    "\nSSN: '" + sSN

        );
    }
}
