
import java.util.Scanner;

public class Validate {

    Scanner in = new Scanner(System.in);

    int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid value. Input again: ");
            }
        }
    }

    int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Values of matrix must be the number. Input again: ");
            }
        }

    }

    int[][] inputMatrix(int nth) {

        System.out.print("Enter Row Matrix [" + nth + "] : ");
        int row = checkIntLimit(1, Integer.MAX_VALUE);
        System.out.print("Enter Colum Matrix [" + nth + "] : ");
        int col = checkIntLimit(1, Integer.MAX_VALUE);

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + nth + "[" + i + "]" + "[" + j + "] : ");
                matrix[i][j] = checkInputInt();
            }
        }
        System.out.println("\n");
        return matrix;
    }

}
