/*  https://leetcode.com/problems/validate-stack-sequences/
    Given two sequences pushed and popped with distinct values, return true if and only if this could 
    have been the result of a sequence of push and pop operations on an initially empty stack.
    Example 1:
      Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
      Output: true
      Explanation: We might do the following sequence:
      push(1), push(2), push(3), push(4), pop() -> 4,
      push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
    Example 2:
      Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
      Output: false
      Explanation: 1 cannot be popped before 2.
*/
import java.util.*;

public class ValidateStackSequences {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<Integer>();
    int size = pushed.length;
    int push = 0, pop = 0;
    while(push < size && pop < size) {
      if(stack.isEmpty() || stack.peek() != popped[pop]) {
        stack.push(pushed[push++]);
      }
      else {
        stack.pop();
        pop++;
      }
    }
    while(pop < size) {
      if(stack.peek() == popped[pop]) {
        stack.pop();
        pop++;
      }
      else {
        break;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    ValidateStackSequences obj = new ValidateStackSequences();
    System.out.println("Validity of pushed = [1,2,3,4,5], popped = [4,5,3,2,1] = " + obj.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}));
    System.out.println("Validity of pushed = [1,2,3,4,5], popped = [4,3,5,1,2] = " + obj.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,3,5,1,2}));
  }
}
