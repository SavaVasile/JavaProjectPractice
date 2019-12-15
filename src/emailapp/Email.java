package emailapp;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for the department - return the department
        this.department = setDepartment();

        //Call a method the returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;


    }

    //Ask for the department
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWYZ0123456789!@#$";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    //Set the mailbox capacity

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    //getters
    public int getMailboxCapacity() {
        return +mailboxCapacity;
    }

    public String getAlternateEmail() {
        return "Your alternate email is: " + alternateEmail;
    }

    public String getPassword() {
        return "Your new password is: " + password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
