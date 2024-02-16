package DFS;

import java.util.*;

//210. Course Schedule II
/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        // Build the graph and calculate in-degrees
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.computeIfAbsent(prerequisiteCourse, k -> new ArrayList<>()).add(course);
            inDegree[course]++;
        }

        // Find courses with in-degree 0 (no prerequisites)
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }

        // Perform topological sort
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            int course = stack.pop();
            result.add(course);

            if (graph.containsKey(course)) {
                for (int neighbor : graph.get(course)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        // Check if all courses are included in the result
        if (result.size() != numCourses) {
            return new int[]{};
        }

        // Convert the result list to an array
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = result.get(i);
        }

        return order;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] order = findOrder(numCourses,prerequisites);
        System.out.printf("The ordering of courses you should take to finish all courses is %s.", Arrays.toString(order));
    }
}
