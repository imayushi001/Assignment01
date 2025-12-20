import java.util.Scanner;

public class matrix {

    static Scanner sc = new Scanner(System.in);

    static void readMatrix(int a[][], int r, int c) {
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                a[i][j] = sc.nextInt();
    }

    static void displayMatrix(int a[][], int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    static void addition(int a[][], int b[][], int r, int c) {
        int sum[][] = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                sum[i][j] = a[i][j] + b[i][j];

        System.out.println("Addition:");
        displayMatrix(sum, r, c);
    }

    static void subtraction(int a[][], int b[][], int r, int c) {
        int sub[][] = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                sub[i][j] = a[i][j] - b[i][j];

        System.out.println("Subtraction:");
        displayMatrix(sub, r, c);
    }

    static void multiplication(int a[][], int b[][], int r, int c) {
        int mul[][] = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                for (int k = 0; k < c; k++)
                    mul[i][j] += a[i][k] * b[k][j];

        System.out.println("Multiplication:");
        displayMatrix(mul, r, c);
    }

    static void transpose(int a[][], int r, int c) {
        int t[][] = new int[c][r];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                t[j][i] = a[i][j];

        System.out.println("Transpose:");
        displayMatrix(t, c, r);
    }

    static void checkDiagonal(int a[][], int n) {
        boolean flag = true;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && a[i][j] != 0)
                    flag = false;

        System.out.println(flag ? "Diagonal Matrix" : "Not Diagonal Matrix");
    }

    static void checkIdentity(int a[][], int n) {
        boolean flag = true;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if ((i == j && a[i][j] != 1) || (i != j && a[i][j] != 0))
                    flag = false;

        System.out.println(flag ? "Identity Matrix" : "Not Identity Matrix");
    }

    public static void main(String[] args) {

        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int a[][] = new int[r][c];
        int b[][] = new int[r][c];

        System.out.println("Enter Matrix A:");
        readMatrix(a, r, c);

        System.out.println("Enter Matrix B:");
        readMatrix(b, r, c);

        addition(a, b, r, c);
        subtraction(a, b, r, c);
        transpose(a, r, c);

        if (r == c) {
            multiplication(a, b, r, c);
            checkDiagonal(a, r);
            checkIdentity(a, r);
        } else {
            System.out.println("Square / Diagonal / Identity not possible");
        }
    }
}
