# https://leetcode.com/problems/arithmetic-slices/
# A sequence of numbers is called arithmetic if it consists of at least three elements and if 
# the difference between any two consecutive elements is the same.
# For example, these are arithmetic sequences:
#   1, 3, 5, 7, 9
#   7, 7, 7, 7
#   3, -1, -5, -9
# The following sequence is not arithmetic.
#   1, 1, 2, 5, 7
# A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair 
# of integers (P, Q) such that 0 <= P < Q < N. A slice (P, Q) of the array A is called arithmetic 
# if the sequence: A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
# The function should return the number of arithmetic slices in the array A.
# Example:
#   A = [1, 2, 3, 4]
#   return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.

from typing import List

class ArithmeticSlices:
  def numberOfArithmeticSlices(self, nums: List[int]) -> int:
    if len(nums) < 3:
      return 0
    i: int = 2
    count: int = 0
    result: int = 0
    while i < len(nums):
      if (nums[i-1] - nums[i-2]) == (nums[i] - nums[i-1]):
        count += 1
      else:
        count = 0
      result += count
      i += 1
    return result

def main():
  obj = ArithmeticSlices()
  print("Solution for array [1, 2, 3, 4] = " + str(obj.numberOfArithmeticSlices([1, 2, 3, 4])))
  print("Solution for array [1, 2, 3, 4, 5, 6] = " + str(obj.numberOfArithmeticSlices([1, 2, 3, 4, 5, 6])))
  print("Solution for array [1, 2, 3, 4, 7, 10, 12, 14] = " + str(obj.numberOfArithmeticSlices([1, 2, 3, 4, 7, 10, 12, 14])))

if __name__ == "__main__":
  main()