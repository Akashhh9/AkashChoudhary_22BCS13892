package AkashChoudhary_22BCS13892.LabExp;
import java.util.Scanner;

//name,accNo,balance,withdrawal,deposit

public class BankingSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String Name = in.nextLine();
        System.out.print("Enter Account Number: ");
        int accNo = in.nextInt();
        System.out.print("Enter Balance: ");
        int balance = in.nextInt();
        System.out.print("Enter withdraw amount: ");
        int withdraw = in.nextInt();
        System.out.print("Enter deposit amount: ");
        int deposit = in.nextInt();

        int amount = deposit + balance - withdraw;
        if (amount < 0) {
            System.out.println("transaction failed!");
        } else {
            System.out.println("Transaction completed. Remaining balance = " + amount);
        }
    }
}
