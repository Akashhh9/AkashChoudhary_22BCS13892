package AkashChoudhary_22BCS13892.LabExp;

import java.util.Scanner;
public class EmpTable {
    public static void main(String[] args) {
        String[][] employees = {
                {"1001", "Ashish", "01/04/2009", "e", "R&D", "20000", "8000", "3000"},
                {"1002", "Sushma", "23/08/2012", "c", "PM", "30000", "12000", "9000"},
                {"1003", "Rahul", "12/11/2008", "k", "Acct", "10000", "8000", "1000"},
                {"1004", "Chahat", "29/01/2013", "r", "Front Desk", "12000", "6000", "2000"},
                {"1005", "Ranjan", "16/07/2005", "m", "Engg", "50000", "20000", "20000"},
                {"1006", "Suman", "01/01/2000", "e", "Manufacturing", "23000", "9000", "4400"},
                {"1007", "Tanmay", "12/06/2006", "c", "PM", "29000", "12000", "10000"}
        };
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-15s %-20s %-10s%n", "Emp No", "Name", "Join Date", "Designation", "Department", "Salary");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (String[] emp : employees) {
            int basic = Integer.parseInt(emp[5]);
            int hra = Integer.parseInt(emp[6]);
            int it = Integer.parseInt(emp[7]);
            int da = getDA(emp[3]);
            int salary = basic + hra + da - it;

            System.out.printf("%-10s %-15s %-15s %-15s %-20s %-10d%n", emp[0], emp[1], emp[2], getDesignation(emp[3]), emp[4], salary);
        }
        System.out.println("--------------------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Employee ID to search: ");
        String empId = scanner.nextLine();
        boolean found = false;
        for (String[] emp : employees) {
            if (emp[0].equals(empId)) {
                found = true;
                int basic = Integer.parseInt(emp[5]);
                int hra = Integer.parseInt(emp[6]);
                int it = Integer.parseInt(emp[7]);
                int da = getDA(emp[3]);
                int salary = basic + hra + da - it;
                System.out.println("\nEmployee Details:");
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-15s %-15s %-15s %-20s %-10s%n", "Emp No", "Name", "Join Date", "Designation", "Department", "Salary");
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-15s %-15s %-15s %-20s %-10d%n", emp[0], emp[1], emp[2], getDesignation(emp[3]), emp[4], salary);
                System.out.println("--------------------------------------------------------------------------------------------");
                break;
            }
        }
       if (!found) {
            System.out.println("Employee not found.");
        }
        scanner.close();
    }
    private static String getDesignation(String code) {
        return switch (code) {
            case "e" -> "Engineer";
            case "c" -> "Consultant";
            case "k" -> "Clerk";
            case "r" -> "Receptionist";
            case "m" -> "Manager";
            default -> "Unknown";
        };
    }
    private static int getDA(String code) {
        return switch (code) {
            case "e" -> 20000;
            case "c" -> 32000;
            case "k" -> 12000;
            case "r" -> 15000;
            case "m" -> 40000;
            default -> 0;
        };
    }
}
