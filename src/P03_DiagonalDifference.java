import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[n][n];

        //1. пълним матрицата
        fillMatrix(matrix, scanner);
        //2. сума на главен диагонал
        int primarySum = primaryDiagonalSum(matrix);
        //3. сума на второстепенен диагонал
        //формула за второстепенен диагонал -> col == rows (редовете) - row (текущия ред) - 1;
        int secondarySum = secondaryDiagonalSum(matrix);
        //4. абсолютна стойност на двете суми -
        int difference = Math.abs(primarySum - secondarySum);
        System.out.println(difference);
    }

    private static int secondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[col][row];
                if (col == matrix.length - row - 1) {
                    sum+= currentElement;
                }
            }
        }
        return sum;
    }

    private static int primaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[col][row];
                if (row == col) {
                    sum+= currentElement;
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
