/****
Interval List Intersections
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.
*/
package leetCodeChallenge.may;

import java.util.ArrayList;
import java.util.List;

public class Interval_List_Intersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        

            List<List<Integer>> outer = new ArrayList();

            for(int i=0 ; i<A.length ; i++){
                for(int j=0 ; j<B.length ; j++) {

                    if (A[i][1] >= B[j][0] && (A[i][1] <= B[j][1] || (A[i][1] >= B[j][1] && B[j][1] >= A[i][0]))){
                        ArrayList<Integer> inner = new ArrayList<Integer>();
                        if ( A[i][0] > B[j][0] ){
                            inner.add(A[i][0]);
                        }else {
                            inner.add(B[j][0]);
                        }
                        if ( A[i][1] > B[j][1] ){
                            inner.add(B[j][1]);
                        }else {
                            inner.add(A[i][1]);
                        }
                        outer.add(inner);
                    }else{
                        if(B[j][1] == A[i][0]){
                            ArrayList list = new ArrayList();
                            list.add(A[i][0]);
                            list.add(B[j][1]);
                            outer.add(list);
                        }

                    }
                }
            }
            int[][] result = new int[outer.size()][2];

            for (int k=0; k < outer.size() ; k++ ) {
                result[k][0] = outer.get(k).get(0);
                result[k][1] = outer.get(k).get(1);

            }
            return result;
        }
    
    

    public static void main(String[] args) {

        Interval_List_Intersections list = new Interval_List_Intersections();
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
       System.out.println( list.intervalIntersection(A, B));
    }
}
