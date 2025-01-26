package Exercise5;
/*
Create a class called 'Matrix' containing constructor
that initializes the number of rows and number of columns
of a new Matrix object. The Matrix class has the following information:
1 - number of rows of matrix
2 - number of columns of matrix
3 - elements of matrix in the form of 2D array
 */

public class Matrix {
    private int row;
    private int col;
    private int[][] elements;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Set elements
    public void setElement(int[][] element) {
        // Check
        if ((element.length != row) || (element[0].length != col)) {
            System.out.println("Wrong setting of elements");
        } else {
            this.elements = element;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
    }
}


class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 3);
        int[][] elements = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.setElement(elements);
        System.out.println("Matrix:");
        matrix.printMatrix();
    }
}
