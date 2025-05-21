/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    const rowCount = matrix.length;
    const colCount = matrix[0].length;
    let rowFlag = false;
    let colFlag = false;

    for (let col = 0; col < colCount; ++col) {
        if (matrix[0][col] === 0) {
            rowFlag = true;
            break;
        }
    }

    for (let row = 0; row < rowCount; ++row) {
        if (matrix[row][0] === 0) {
            colFlag = true;
            break;
        }
    }

    for (let row = 1; row < rowCount; ++row) {
        for (let col = 1; col < colCount; ++col) {
            if (matrix[row][col] === 0) {
                matrix[row][0] = 0;
                matrix[0][col] = 0;
            }
        }
    }

    for (let row = 1; row < rowCount; ++row) {
        for (let col = 1; col < colCount; ++col) {
            if (matrix[row][0] === 0 || matrix[0][col] === 0) {
                matrix[row][col] = 0;
            }
        }
    }

    if (rowFlag) {
        for (let col = 0; col < colCount; ++col) {
            matrix[0][col] = 0;
        }
    }

    if (colFlag) {
        for (let row = 0; row < rowCount; ++row) {
            matrix[row][0] = 0;
        }
    }
};
