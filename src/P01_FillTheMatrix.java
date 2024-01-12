import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];


        int [][] matrix = new int [n][n];

        if (pattern.equals("A")){
            getFillTheMatrixPatternA(matrix);

        } else if (pattern.equals("B")) {
            getFillTheMatrixPatternB(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }

    private static void getFillTheMatrixPatternB(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if(col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0 ; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }

    }

    private static void getFillTheMatrixPatternA(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }
}
