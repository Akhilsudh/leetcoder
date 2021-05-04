#  https://leetcode.com/problems/running-sum-of-1d-array/
#  Given an array nums. We define a running sum of an array as 
#  runningSum[i] = sum(nums[0]…nums[i]). Return the running sum of nums.
#  Example 1:
#    Input: nums = [1,2,3,4]
#    Output: [1,3,6,10]
#    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
from typing import List

class RunningSumOf1dArray:
  def runningSum(self, nums: List[int]) -> List[int]:
    sum: int = 0
    i: int = 1
    while i < len(nums):
      nums[i] += nums[i - 1]
      i += 1
    return nums

def main():
  obj = RunningSumOf1dArray()
  res = obj.runningSum([1, 2, 3, 4])
  print(res)

if __name__ == "__main__":
  main()