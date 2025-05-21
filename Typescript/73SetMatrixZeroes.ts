/**
 * Do not return anything, modify matrix in-place instead.
 */
function setZeroes(matrix: number[][]): void {
    const rowCount: number = matrix.length;
    const colCount: number = matrix[0].length;
    let rowFlag: boolean = false;
    let colFlag: boolean = false;

    // Check if the first row has any zeros
    for (let col = 0; col < colCount; ++col) {
        if (matrix[0][col] === 0) {
            rowFlag = true;
            break;
        }
    }

    // Check if the first column has any zeros
    for (let row = 0; row < rowCount; ++row) {
        if (matrix[row][0] === 0) {
            colFlag = true;
            break;
        }
    }

    // Use first row and column as markers
    for (let row = 1; row < rowCount; ++row) {
        for (let col = 1; col < colCount; ++col) {
            if (matrix[row][col] === 0) {
                matrix[row][0] = 0;
                matrix[0][col] = 0;
            }
        }
    }

    // Set matrix cells to zero based on markers
    for (let row = 1; row < rowCount; ++row) {
        for (let col = 1; col < colCount; ++col) {
            if (matrix[row][0] === 0 || matrix[0][col] === 0) {
                matrix[row][col] = 0;
            }
        }
    }

    // Set first row to zero if needed
    if (rowFlag) {
        for (let col = 0; col < colCount; ++col) {
            matrix[0][col] = 0;
        }
    }

    // Set first column to zero if needed
    if (colFlag) {
        for (let row = 0; row < rowCount; ++row) {
            matrix[row][0] = 0;
        }
    }
}
