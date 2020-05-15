package leetCodeChallenge.may;

public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1;
        while (r >= l) {

            if((r == nums.length-1) && (l+1) == r){
                return nums[r];
            }

            int mid = (l + r) / 2;

            if(mid == 0){
                return nums[0];
            }

            if (mid >0 && mid < nums.length && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if( (mid+1) % 2 != 0 ){
                if(nums[mid-1] == nums[mid]){
                    r = mid;
                }else{
                   if(nums[mid+1] == nums[mid]){
                       l = mid;
                   }
                }

            }else {
                if(nums[mid-1] == nums[mid]){
                    l = mid;
                }else{
                    if(nums[mid+1] == nums[mid]){
                        r = mid;
                    }
                }

            }
        }
        return -1;
    }
    public static void main(String[] args) {
          int[] arr = {1,1,2,3,3,4,4,8,8};
        SingleNonDuplicate sum = new SingleNonDuplicate();
          System.out.println(sum.singleNonDuplicate(arr));

    }
}
