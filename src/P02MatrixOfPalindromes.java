import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String [][] matrix = new String[rows][cols];

        char startLetter = 'a';

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String palindrome = ""+ startLetter + (char)(startLetter + col) + startLetter; //конкатенираме с празен стринг, за да може символите от тип char да го приеме като стринг
                matrix[row][col] = palindrome;
            }
            startLetter = (char)(startLetter + 1);// преди да премине на следващия ред, увеличава буквата с едно
        }
        printMatrix(matrix, rows, cols);
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }
}
