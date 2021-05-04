public class RunningSumOf1dArray {
  public int[] runningSum(int[] nums) {
    int[] result = new int[nums.length];
    int sum = 0;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
      result[i] = sum;
    }
    return result;
  }

  private void printArray(int[] nums) {
    System.out.print("[ ");
    for(int num: nums) {
      System.out.print(num + " ");
    }
    System.out.println("]");
  }
  public static void main(String[] args) {
    RunningSumOf1dArray obj = new RunningSumOf1dArray();
    obj.printArray(obj.runningSum(new int[] {1, 1, 1, 1, 1}));
    obj.printArray(obj.runningSum(new int[] {1, 2, 3, 4}));
    obj.printArray(obj.runningSum(new int[] {3, 1, 2, 10, 1}));
  }
}
