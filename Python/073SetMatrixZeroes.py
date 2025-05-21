class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None. Do not return anything, modify matrix in-place instead.
        """
        rowCount = len(matrix)
        colCount = len(matrix[0])
        rowFlag = False
        colFlag = False

        # Check if the first row has any zeros
        for col in range(colCount):
            if matrix[0][col] == 0:
                rowFlag = True
                break

        # Check if the first column has any zeros
        for row in range(rowCount):
            if matrix[row][0] == 0:
                colFlag = True
                break

        # Use first row and column as markers
        for row in range(1, rowCount):
            for col in range(1, colCount):
                if matrix[row][col] == 0:
                    matrix[row][0] = 0
                    matrix[0][col] = 0

        # Set elements to 0 based on markers
        for row in range(1, rowCount):
            for col in range(1, colCount):
                if matrix[row][0] == 0 or matrix[0][col] == 0:
                    matrix[row][col] = 0

        # Zero the first row if needed
        if rowFlag:
            for col in range(colCount):
                matrix[0][col] = 0

        # Zero the first column if needed
        if colFlag:
            for row in range(rowCount):
                matrix[row][0] = 0
