import java.util.*;

public class MinimumCostForTicketsDPRecursion {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daysSet = new HashSet<Integer>(days.length);
        int[] lookup = new int[days[days.length - 1] + 1];
        for(int i: days) {
            daysSet.add(i);
        }
        return recursive(lookup.length - 1, lookup, daysSet, costs);
    }

    public int recursive(int index, int[] lookup, Set<Integer> daysSet, int[] costs) {
        if(index <= 0) {
            return 0;
        }
        else if (!daysSet.contains(index)) {
            lookup[index] = recursive(index - 1, lookup, daysSet, costs);
        }
        else {
            int a = recursive(index - 1, lookup, daysSet, costs) + costs[0];
            int b = recursive(index - 7, lookup, daysSet, costs) + costs[1];
            int c = recursive(index - 30, lookup, daysSet, costs) + costs[2];
            lookup[index] = Math.min(a, Math.min(b, c));
        }
        return lookup[index];
    }
}