class Solution {
    public void setZeroes(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        boolean rowFlag = false;
        boolean colFlag = false;

        // Check if the first row has any zeros
        for (int col = 0; col < colCount; ++col) {
            if (matrix[0][col] == 0) {
                rowFlag = true;
                break;
            }
        }

        // Check if the first column has any zeros
        for (int row = 0; row < rowCount; ++row) {
            if (matrix[row][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int row = 1; row < rowCount; ++row) {
            for (int col = 1; col < colCount; ++col) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < rowCount; ++row) {
            for (int col = 1; col < colCount; ++col) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (rowFlag) {
            for (int col = 0; col < colCount; ++col) {
                matrix[0][col] = 0;
            }
        }

        if (colFlag) {
            for (int row = 0; row < rowCount; ++row) {
                matrix[row][0] = 0;
            }
        }
    }
}
