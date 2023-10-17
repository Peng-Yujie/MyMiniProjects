package com.miniFund.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MiniFundSysOOP {
    boolean loop = true;
    Scanner sc = new Scanner(System.in);
    String key = "";
    String details = "=============== Fund Details ===============";

    // Initial balance
    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String note = "";

    public void menu(){
        System.out.println("Welcome to MiniFundSys");
        do{
            System.out.println("\n============== Mini Fund Menu ==============");
            System.out.println("\t\t\t1. Details");
            System.out.println("\t\t\t2. Earnings");
            System.out.println("\t\t\t3. Payments");
            System.out.println("\t\t\t4. Exit\n");

            System.out.print("Enter your choice: ");
            key = sc.next();
            switch (key){
                case "1":
                    details();
                    break;
                case "2":
                    earnings();
                    break;
                case "3":
                    pay();
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }while (loop);
        System.out.println("Thank you for using MiniFundSys");
    }
    public void details(){
        System.out.println(details);
    }
    public void earnings(){
        System.out.print("Enter Earnings: ");
        money = sc.nextDouble();
        // Check if money is positive
        if (money < 0) {
            System.out.println("Invalid input");
            return;
        }
        balance += money;
        date = new Date();
        details += "\nEarnings\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    public void pay(){
        System.out.print("Enter payment: ");
        money = sc.nextDouble();
        if(money < 0 || money > balance) {
            System.out.println("Invalid input");
            return;
        }
        System.out.print("Enter note: ");
        note = sc.next();
        balance -= money;
        date = new Date();
        details += "\n"+note+"\t-" + money + "\t" + sdf.format(date) + "\t" + balance + "\t";
    }
    public void exit(){
        String confirm = "";
        while(true) {
            System.out.println("Are you sure to exit? (Y/N)");
            confirm = sc.next();
            if ("Y".equalsIgnoreCase(confirm) || "N".equalsIgnoreCase(confirm)) {
                break;
            }
        }
        if ("Y".equalsIgnoreCase(confirm)) {
            loop = false;
        }
    }
}
