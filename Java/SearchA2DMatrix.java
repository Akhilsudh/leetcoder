/*  https://leetcode.com/problems/search-a-2d-matrix/
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    - Integers in each row are sorted from left to right.
    - The first integer of each row is greater than the last integer of the previous row.

        Example 1:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
        Output: true

        Example 2:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
        Output: false

        Example 3:
        Input: matrix = [], target = 0
        Output: false
*/
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int l = 0;
        int r = matrix.length - 1;
        int m = 0;
        while(l <= r) {
            m = (l + r)/2;
            if(target == matrix[m][0]) {
                return true;
            }
            else if(target < matrix[m][0]) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        int i = m;
        if(target < matrix[m][0]) {
            i = m - 1;
        }
        if(i < 0) {
            return false;
        }
        l = 0;
        r = matrix[i].length - 1;
        while(l <= r) {
            m = (l + r)/2;
            if(target == matrix[i][m]) {
                return true;
            }
            else if(target < matrix[i][m]) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return false;
    }
}
