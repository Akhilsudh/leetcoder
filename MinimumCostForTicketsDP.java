import java.util.*;

public class MinimumCostForTicketsDP {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daysSet = new HashSet<Integer>(days.length);
        int[] lookup = new int[days[days.length] + 1];
        for(int i: days) {
            daysSet.add(i);
        }
        for(int i = 1; i < lookup.length; i++) {
            if(!daysSet.contains(i)){
                lookup[i] = lookup[i - 1];
            }
            else {
                int a = lookup[Math.max(0, i - 1)] + costs[0];
                int b = lookup[Math.max(0, i - 7)] + costs[1];
                int c = lookup[Math.max(0, i - 30)] + costs[2];
                lookup[i] = Math.min(a, Math.min(b, c));
            }
        }
        return lookup[lookup.length - 1];
    }
}