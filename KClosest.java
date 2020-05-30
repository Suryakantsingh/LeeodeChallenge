/*
*K Closest Points to Origin
*
*
*/
package leetCodeChallenge.may;

import java.util.*;

public class KClosest {
    
    public int[][] secondApproach(int[][] points, int K){

        int[][] result = new int[K][2];
        TreeMap<Double, Integer> sortedMap = new TreeMap<>();

        for(int i = 0 ; i < points.length ; i++) {

            double sum = Math.sqrt(Math.pow(points[i][0],2) + Math.pow(points[i][1],2));

               if( sortedMap.size() == K){

                  Double value = sortedMap.lastKey();
                    if(value > sum){
                        sortedMap.remove(value);
                        if(!sortedMap.containsKey(sum)) {
                            sortedMap.put(sum, i);
                        }else{
                            sortedMap.put(sum+1, i);
                        }
                    }

                }else{
                  if(!sortedMap.containsKey(sum)) {
                      sortedMap.put(sum, i);
                  }else{
                      sortedMap.put(sum+1,i);
                  }
                }
            }
            List<Integer> list = new ArrayList<>(sortedMap.values());
        for(int k=0; k < list.size() ; k++) {

            result[k][0] = points[list.get(k)][0];
            result[k][1] = points[list.get(k)][1];
        }
       return result;
    }

    public static void main(String[] args) {

        KClosest sol = new KClosest();
        int[][] point = {{1,3},{-2,2},{2,-2}};
        int[][] result = sol.secondApproach(point, 2);
      //  System.out.println(result.toString());
        for(int i=0;i<result.length ; i++){
             System.out.print("[ "+result[i][0]+" , "+result[i][1]+" ]"+" ");
        }
    }
}
