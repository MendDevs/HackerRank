//////////////////// Matrix Inversion Function Hacker Rank ///////////////////////////
def flippingMatrix(matrix):
    n = len(matrix) // 2
    max_sum = 0
    
    for i in range(n):
        for j in range(n):
            # Get the maximum value from the four candidates
            max_value = max(
                matrix[i][j],                     # (i, j)
                matrix[i][2*n - 1 - j],           # (i, 2n - 1 - j)
                matrix[2*n - 1 - i][j],           # (2n - 1 - i, j)
                matrix[2*n - 1 - i][2*n - 1 - j]  # (2n - 1 - i, 2n - 1 - j)
            )
            max_sum += max_value
    
    return max_sum
