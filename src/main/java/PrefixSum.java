/**
 * This class calculates the sum between (x1, y1) and (x2, y2) in O(1) time with O(N*M) pre-process (N = rows, M = cols)
 * @author Horatiu Lazu
 * @version 1.0
 */
public class PrefixSum {
    private int [][] sum;

    public PrefixSum(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        sum = new int[matrix.length+1][matrix[0].length+1];
        for (int i=0; i<matrix.length; i++) {
            int tmp = 0;
            for (int j=0; j<matrix[0].length; j++) {
                tmp += matrix[i][j];
                sum[i+1][j+1] = sum[i][j+1] + tmp;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum.length == 0)
            return 0;
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}
