/*  https://leetcode.com/problems/longest-mountain-in-array/
    Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
    B.length >= 3
    There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
    (Note that B could be any subarray of A, including the entire array A.)
    Given an array A of integers, return the length of the longest mountain. 
    Return 0 if there is no mountain.

    Example 1:
      Input: [2,1,4,7,3,2,5]
      Output: 5
      Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

    Example 2:
      Input: [2,2,2]
      Output: 0
      Explanation: There is no mountain.
    
    Note:
      0 <= A.length <= 10000
      0 <= A[i] <= 10000

    Follow up:
    Can you solve it using only one pass?
    Can you solve it in O(1) space?
*/
class LongestMountainInArray {
  public int longestMountain(int[] A) {
    if(A.length < 3) {
      return 0;
    }
    boolean init = false;
    boolean descend = false;
    int result = 0;
    int temp = 1;
    for(int i = 1; i < A.length; i++) {
      if(A[i] == A[i - 1]) {
          if(descend) {
            result = Math.max(result, temp);
          }
          temp = 1;
          init = false;
          descend = false;
      }
      else if(A[i] > A[i - 1]) {
        init = true;
        if(!descend) {
          temp++;
        }
        else {
          result = Math.max(result, temp);
          temp = 2;
          descend = false;
        }
      }
      else if(A[i] < A[i - 1] && (i - 1 != 0) && init) {
        if(!descend) {
          descend = true;
        }
        temp++;
      }
    }
    return (descend) ? Math.max(result, temp) : result;
  }
  public static void main(String[] args) {
    LongestMountainInArray obj = new LongestMountainInArray();
    System.out.println(obj.longestMountain(new int[] {2,1,4,7,3,2,5}));
    System.out.println(obj.longestMountain(new int[] {2,2,2}));
    System.out.println(obj.longestMountain(new int[] {9,8,7,6,5,4,3,2,1}));
    System.out.println(obj.longestMountain(new int[] {2,3,3,2,1,0,1}));
    System.out.println(obj.longestMountain(new int[] {1,2,3,4,3,2,2,3,4,5,4,3,2,1,1,1}));
  }
}