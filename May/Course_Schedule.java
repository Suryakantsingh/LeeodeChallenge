/*
Course Schedule
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

*/
package leetCodeChallenge.may;

import java.util.ArrayList;
import java.util.List;

public class Course_Schedule {
    boolean result = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> traversed = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            List<Integer> inner = new ArrayList<Integer>();
            outer.add(i, inner);
        }

        for( int j = 0 ; j < prerequisites.length ; j++ ) {
            int m = prerequisites[j][1];
            int n = prerequisites[j][0];

            if(outer.get(m).contains(n)){
                return false;
            }else{
                if(traversed.contains(n)){
                    if(!check(m,n,outer)){
                        return false;
                    }
                    outer.get(n).add(m);
                    traversed.add(m);
                }else {
                    outer.get(n).add(m);
                    traversed.add(m);
                }
            }
        }
        return true;
    }
    public boolean check(int m,int n ,List<List<Integer>> outer) {
        if(outer.get(m).contains(n)){
            result = false;
        }
        for(int i = 0 ; i<outer.get(m).size() ;i++) {
            check(outer.get(m).get(i),n,outer);
        }
        return result;
    }
    public static void main(String[] args) {

        Course_Schedule schedule = new Course_Schedule();
        int[][] prerequisites = {{1, 0},{0,3},{2,1},{3,2}};
        System.out.println(schedule.canFinish(4, prerequisites));
    }
}
