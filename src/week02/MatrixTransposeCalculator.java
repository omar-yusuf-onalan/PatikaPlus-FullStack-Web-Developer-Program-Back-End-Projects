package week02;

// Matris Transpozunu Bulma

public class MatrixTransposeCalculator {
    /*
    In the context of matrices, the process of transposing is actually just looping through each element and
    swapping its row and column value. In order to do this, we need to create a "temp" array which has its
    rows and columns reversed and assign values to it. Therefore, if the original matrix is "int [2][3],"
    then temp is "int [3][2]."
    */
    public static void transposeMatrix (int[][] matrix, int row, int col) {
        int[][] temp = new int[col][row];

        for (row = 0; row < matrix.length; row++) { // row = 0
            for (col = 0; col < matrix[row].length; col++) { // col = 1
                temp[col][row] = matrix[row][col]; // temp[1][0] = matrix[0][1]
            }
        }
        System.out.println("Matrix: ");
        for (int[] r : matrix){
            for (int c : r){
                System.out.print(c + "    ");
            }
            System.out.println("\n");
        }
        System.out.println("Transposed Matrix: ");
        for (int[] r : temp){
            for (int c : r){
                System.out.print(c + "    ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int [][] example = {{1, 2, 3}, {4, 5, 6}};

        transposeMatrix(example, 2, 3);
    }
}
