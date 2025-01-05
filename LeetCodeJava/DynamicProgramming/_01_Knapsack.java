package DynamicProgramming;

import java.util.*;

public class _01_Knapsack {


    public int knapsack(int capacity, List<Integer> weights, List<Integer> values) {
        return recurse(capacity, weights, values, 0, 0);
    }

    private int recurse(int capacity, List<Integer> weights, List<Integer> values, int index, int result) {
        if(capacity == 0) {
            return result;
        } if(capacity < 0) {
            return result - values.get(index - 1);
        } if(index >= weights.size()) {
            return result;
        } if (index == weights.size() - 1) {
            if(capacity - weights.get(index) >= 0) {
                result += values.get(index);
            }
            return result;
        }
        result = Math.max(
                    recurse(capacity - weights.get(index), weights, values, index + 1, result + values.get(index)),
                    recurse(capacity, weights, values, index + 1, result)
                );
        return result;
    }

    public static void main(String[] args) {
        _01_Knapsack obj = new _01_Knapsack();

        List<Integer> weights1 = Arrays.asList(5, 3, 4, 1);
        List<Integer> values1 = Arrays.asList(70, 50, 40, 10);
        System.out.println(obj.knapsack(7, weights1, values1));

        List<Integer> weights2 = Arrays.asList(5, 4, 6, 3);
        List<Integer> values2 = Arrays.asList(10, 40, 30, 50);
        System.out.println(obj.knapsack(5, weights2, values2));
    }
}
