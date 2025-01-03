package Grind75;

import java.util.*;

public class _34_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] prerequisite: prerequisites) {
            inDegree[prerequisite[0]]++;
            graph.computeIfAbsent(prerequisite[1], k -> new HashSet<Integer>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);
            Set<Integer> childNodes = graph.get(node);
            if(childNodes != null){
                for(Integer childNode: childNodes) {
                    if(inDegree[childNode] > 0) {
                        inDegree[childNode]--;
                        if(inDegree[childNode] == 0) {
                            queue.offer(childNode);
                        }
                    }
                }
            }
        }
        return visited.size() == numCourses;
    }

    public static void main(String[] args) {
        _34_CourseSchedule obj = new _34_CourseSchedule();
        System.out.println(obj.canFinish(2, new int[][] {{1,0},{0,1}}));
    }
}
