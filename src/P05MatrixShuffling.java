import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);

        String[][] matrix = new String[rows][cols];

        //пълним си матрицата с метода
        fillMatrix(matrix, scanner);


        String command = scanner.nextLine();


        while (!command.equals("END")) {
          if(!isValidCommand(command, rows, cols)) {
              System.out.println("Invalid input!");
          } else {
              String[] commandParts = command.split("\\s+");
              int row1 = Integer.parseInt(commandParts[1]);
              int col1 = Integer.parseInt(commandParts[2]);
              int row2 = Integer.parseInt(commandParts[3]);
              int col2 = Integer.parseInt(commandParts[4]);

              String firstElement = matrix[row1][col1];
              String secondElement = matrix[row2][col2];

              matrix[row1][col1] = secondElement;
              matrix[row2][col2] = firstElement;
              printMatrix(matrix);
          }

                command = scanner.nextLine();
            }

        }


    public static boolean isValidCommand(String command, int rows, int cols) {
        String[] commandParts = command.split("\\s+");

        if(commandParts.length != 5) {
            return false;
        }

        if(!commandParts[0].equals("swap")) {
            return false;
        }

        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if(row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
          return false;
        }
        return true;
    }


        private static void printMatrix(String[][] matrix) {
            for (int col = 0; col < matrix.length; col++) {
                for (int row = 0; row < matrix[col].length; row++) {
                    System.out.print(matrix[col][row] + " ");
                }
                System.out.println();
            }
        }
    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
                matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
