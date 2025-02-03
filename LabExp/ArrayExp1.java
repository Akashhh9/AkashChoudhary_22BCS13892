package AkashChoudhary_22BCS13892.LabExp;
import java.util.Scanner;

public class ArrayExp1 {
    public static void main(String[] args) {
//        int[] a= new int[10];
//        Scanner in= new Scanner(System.in);
//        for(int i=0;i<10;i++){
//            a[i]=in.nextInt();
//        }
//        System.out.println("Array entered is : ");
//        for(int j=0;j<10;j++){
//            System.out.println(a[j]);
//        }
//        in.close();
//
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the matrix(n*n) {For ex, if the matrix is 2*2, enter 2}: ");
        int n = scanner.nextInt();
        int[][] matrixA = new int[n][n];
        int[][] matrixB = new int[n][n];

        System.out.println("Enter elements of matrix A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter elements of matrix B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }
                // addition
        int[][] additionResult = addMatrices(matrixA, matrixB, n);
        System.out.println("Addition Result:");
        printMatrix(additionResult, n);
                // subtraction
        int[][] subtractionResult = subtractMatrices(matrixA, matrixB, n);
        System.out.println("Subtraction Result:");
        printMatrix(subtractionResult, n);
                // multiplication
        int[][] multiplicationResult = multiplyMatrices(matrixA, matrixB, n);
        System.out.println("Multiplication Result:");
        printMatrix(multiplicationResult, n);
        }

        public static int[][] addMatrices(int[][] matrixA, int[][] matrixB, int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }
    public static int[][] subtractMatrices(int[][] matrixA, int[][] matrixB, int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB, int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }
    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
