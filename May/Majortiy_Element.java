package leetCodeChallenge.may;

import java.util.HashMap;

public class Majortiy_Element {

    public int majorityElement(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length/2;
        int key = 0;
        for(int i = 0 ; i<nums.length ; i++){
            int value = nums[i];

            if(!map.containsKey(nums[i])){
                map.put(value,1);
            }else{
                int count = map.get(value);
                map.put(value,count+1);
                if((count+1) > n && (count+1) > key){
                    key = value;
                }
            }
        }
       return key;
    }

    public static void main (String[] args) {

        int[] arr = new int[]{1};
        Majortiy_Element element = new Majortiy_Element();
        System.out.println(element.majorityElement(arr));
    }
}
