package AkashChoudhary_22BCS13892.LabExp;

import java.util.Scanner;
abstract class Account {
    double interestRate;
    double amount;
    abstract double calculateInterest();
}

class FDAccount extends Account {
    int noOfDays;
    int ageOfACHolder;
    @Override
    double calculateInterest() {
        if (amount <= 0 || noOfDays <= 0 || ageOfACHolder <= 0) {
            throw new IllegalArgumentException("Invalid input values.");
        }
        if (amount < 10000000) {
            if (noOfDays >= 7 && noOfDays <= 14) interestRate = (ageOfACHolder >= 60) ? 5.0 : 4.5;
            else if (noOfDays >= 15 && noOfDays <= 29) interestRate = (ageOfACHolder >= 60) ? 5.25 : 4.75;
            else if (noOfDays >= 30 && noOfDays <= 45) interestRate = (ageOfACHolder >= 60) ? 6.0 : 5.5;
            else if (noOfDays >= 46 && noOfDays <= 60) interestRate = (ageOfACHolder >= 60) ? 7.5 : 7.0;
            else if (noOfDays >= 61 && noOfDays <= 184) interestRate = (ageOfACHolder >= 60) ? 8.0 : 7.5;
            else if (noOfDays >= 185 && noOfDays <= 365) interestRate = (ageOfACHolder >= 60) ? 8.5 : 8.0;
        } else {
            if (noOfDays >= 7 && noOfDays <= 14) interestRate = 6.5;
            else if (noOfDays >= 15 && noOfDays <= 29) interestRate = 6.75;
            else if (noOfDays >= 30 && noOfDays <= 45) interestRate = 6.75;
            else if (noOfDays >= 46 && noOfDays <= 60) interestRate = 8.0;
            else if (noOfDays >= 61 && noOfDays <= 184) interestRate = 8.5;
            else if (noOfDays >= 185 && noOfDays <= 365) interestRate = 10.0;
        }
        return amount * interestRate / 100;
    }
}

class SBAccount extends Account {
    String accountType;
    @Override
    double calculateInterest() {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount.");
        }

        if (!accountType.equalsIgnoreCase("Normal") && !accountType.equalsIgnoreCase("NRI")) {
            throw new IllegalArgumentException("Invalid account type. Please enter 'Normal' or 'NRI'.");
        }

        interestRate = accountType.equalsIgnoreCase("NRI") ? 6.0 : 4.0;
        return amount * interestRate / 100;
    }
}

class RDAccount extends Account {
    int noOfMonths;
    double monthlyAmount;
    int ageOfACHolder;
    @Override
    double calculateInterest() {
        if (monthlyAmount <= 0 || noOfMonths <= 0 || ageOfACHolder <= 0) {
            throw new IllegalArgumentException("Invalid input values.");
        }
        if (noOfMonths == 6) interestRate = (ageOfACHolder >= 60) ? 8.0 : 7.5;
        else if (noOfMonths == 9) interestRate = (ageOfACHolder >= 60) ? 8.25 : 7.75;
        else if (noOfMonths == 12) interestRate = (ageOfACHolder >= 60) ? 8.5 : 8.0;
        else if (noOfMonths == 15) interestRate = (ageOfACHolder >= 60) ? 8.75 : 8.25;
        else if (noOfMonths == 18) interestRate = (ageOfACHolder >= 60) ? 9.0 : 8.5;
        else if (noOfMonths == 21) interestRate = (ageOfACHolder >= 60) ? 9.25 : 8.75;
        double maturityAmount = 0;
        for (int i = 0; i < noOfMonths; i++) {
            maturityAmount += monthlyAmount * Math.pow(1 + (interestRate / 400), 4);
        }
        return maturityAmount - (monthlyAmount * noOfMonths);
    }
}

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Select the option:\n1. Interest Calculator –SB\n2. Interest Calculator –FD\n3. Interest Calculator –RD\n4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    SBAccount sb = new SBAccount();
                    System.out.print("Enter the average amount in your account: ");
                    sb.amount = sc.nextDouble();
                    System.out.print("Enter the type of account (Normal/NRI): ");
                    sb.accountType = sc.next();
                    System.out.println("Interest gained: Rs. " + sb.calculateInterest());
                }
                case 2 -> {
                    FDAccount fd = new FDAccount();
                    System.out.print("Enter the FD amount: ");
                    fd.amount = sc.nextDouble();
                    System.out.print("Enter the number of days: ");
                    fd.noOfDays = sc.nextInt();
                    System.out.print("Enter your age: ");
                    fd.ageOfACHolder = sc.nextInt();
                    System.out.println("Interest gained is: Rs. " + fd.calculateInterest());
                }
                case 3 -> {
                    RDAccount rd = new RDAccount();
                    System.out.print("Enter the monthly amount: ");
                    rd.monthlyAmount = sc.nextDouble();
                    System.out.print("Enter the number of months: ");
                    rd.noOfMonths = sc.nextInt();
                    System.out.print("Enter your age: ");
                    rd.ageOfACHolder = sc.nextInt();
                    System.out.println("Interest gained is: Rs. " + rd.calculateInterest());
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

