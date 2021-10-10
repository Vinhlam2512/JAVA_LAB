
public class Main {

    public static void main(String[] args) {

        Validate val = new Validate();
        Calculator cal = new Calculator();
        int[][] matrix1;
        int[][] matrix2;
        while (true) {
            System.out.println("=======Calculator program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = val.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    System.out.println("**Addition**");
                    matrix1 = val.inputMatrix(1);
                    matrix2 = val.inputMatrix(2);
                    cal.addMatrixResult(matrix1, matrix2);
                    break;
                case 2:
                    System.out.println("**Subtraction**");
                    matrix1 = val.inputMatrix(1);
                    matrix2 = val.inputMatrix(2);
                    cal.subMatrixResult(matrix1, matrix2);
                    break;
                case 3:
                    System.out.println("**Multiply**");
                    matrix1 = val.inputMatrix(1);
                    matrix2 = val.inputMatrix(2);
                    cal.multipleMatrixResult(matrix1, matrix2);
                    break;
                case 4:
                    return;
            }
        }
    }
}
