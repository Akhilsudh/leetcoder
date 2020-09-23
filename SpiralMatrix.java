/*  https://leetcode.com/problems/spiral-matrix/
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    Example 1:
    Input:
    [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
    ]
    Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
    Input:
    [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9,10,11,12]
    ]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0) {
            return res;
        }
        int startrow = 0;
        int endrow = matrix.length - 1;
        int startcol = 0;
        int endcol = matrix[0].length - 1;
        while(true) {
            for(int i = startcol; i <= endcol; i++) {
                res.add(matrix[startrow][i]);
            }
            startrow++;
            if(startrow > endrow) break;
            
            for(int i = startrow; i <= endrow; i++) {
                res.add(matrix[i][endcol]);
            }
            endcol--;
            if(startcol > endcol) break;
            
            for(int i = endcol; i >= startcol; i--) {
                res.add(matrix[endrow][i]);
            }
            endrow--;
            if(startrow > endrow) break;
            
            for(int i = endrow; i >= startrow; i--) {
                res.add(matrix[i][startcol]);
            }
            startcol++;
            if(startcol > endcol) break;
        }
        return res;
    }
}
