/**
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

*/
public class Count_Square_Submatrices {

    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int count = 0;
        int m = matrix[0].length;
        int minSquare = 0;
        if (m < n) {
            minSquare = m;
        } else {
            minSquare = n;
        }
        for (int i = 0; i < minSquare; i++) {
            for (int j = 0; j < n - i;  j++) {
                for (int k = 0; k < m - i; k++) {
                        if(i == 0) {
                            if (matrix[j][k] == 1) {
                                count++;
                            }
                        }else{
                            if(checkSquare(matrix,j,k,i)){
                                count++;
                            }
                        }

                    }

                }
            }

        System.out.println(count);
        return count;
    }
    public boolean checkSquare(int[][] matrix, int j,int k , int i){
        boolean flag = true;
        for(int l = j ; l<= j+i; l++){
            for(int m = k ; m <=k+i ; m++){
                if(matrix[l][m] == 1){
                    flag = true;
                }else{
                    return false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {1, 1, 0}, { 1, 1, 0}};
        Count_Square_Submatrices mat = new Count_Square_Submatrices();
        mat.countSquares(matrix);
    }
}
