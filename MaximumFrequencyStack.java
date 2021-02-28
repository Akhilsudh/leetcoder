/*  https://leetcode.com/problems/maximum-frequency-stack/
    Implement FreqStack, a class which simulates the operation of a stack-like data structure.
    FreqStack has two functions:
        push(int x), which pushes an integer x onto the stack.
        pop(), which removes and returns the most frequent element in the stack.
        If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
    Example 1:
      Input: 
        ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
        [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
      Output: [null,null,null,null,null,null,null,5,7,5,4]
      Explanation:
        After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
        pop() -> returns 5, as 5 is the most frequent.
        The stack becomes [5,7,5,7,4].
        pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
        The stack becomes [5,7,5,4].
        pop() -> returns 5.
        The stack becomes [5,7,4].
        pop() -> returns 4.
        The stack becomes [5,7].
*/
import java.util.*;

class FreqStack {
  Map <Integer, Integer> frequencyMap;
  Map <Integer, Stack<Integer>> frequencyStackMap;
  int maxFrequency;

  public FreqStack() {
    frequencyMap = new HashMap<Integer, Integer>();
    frequencyStackMap = new HashMap<Integer, Stack<Integer>>();
    maxFrequency = 0;
  }
  
  public void push(int x) {
    int frequency;
    if(frequencyMap.containsKey(x)) {
      frequency = frequencyMap.get(x) + 1;
      frequencyMap.put(x, frequency);
    }
    else {
      frequency = 1;
      frequencyMap.put(x, frequency);
    }
    maxFrequency = Math.max(maxFrequency, frequency);
    Stack<Integer> s;
    if(frequencyStackMap.containsKey(frequency)) {
      s = frequencyStackMap.get(frequency);
      s.push(x);
    }
    else {
      s = new Stack<Integer>();
      s.push(x);
      frequencyStackMap.put(frequency, s);
    }
  }
  
  public int pop() {
      Stack<Integer> s = frequencyStackMap.get(maxFrequency);
      int result = s.pop();
      if(s.isEmpty()) {
        frequencyStackMap.remove(maxFrequency);
        maxFrequency -= 1;
      }
      frequencyMap.put(result, frequencyMap.get(result) - 1);
      return result;
  }
}

class MaximumFrequencyStack {
  public static void main(String[] args) {
    FreqStack fs = new FreqStack();
    fs.push(5); fs.push(7); fs.push(5); fs.push(7); fs.push(4); fs.push(5);
    System.out.println(fs.pop());
    System.out.println(fs.pop());
    System.out.println(fs.pop());
    System.out.println(fs.pop());
    System.out.println(fs.pop());
    System.out.println(fs.pop());
  }
}
