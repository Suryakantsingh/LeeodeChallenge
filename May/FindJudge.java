package leetCodeChallenge.may;

import java.util.*;

public class FindJudge {

    public int findJudge(int N, int[][] trust) {
       int[] arr = new int[N+1];
        for(int i = 0; i < trust.length;i++){
            arr[trust[i][0]]--;
            arr[trust[i][1]]++;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i] == (N-1)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindJudge find = new FindJudge();
        int[][] trust = {{1, 3},{2,3}};
        System.out.println(find.findJudge(3, trust));
    }
}
