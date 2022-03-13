package 二分查找;
public class 旋转数组的最小数字 {
    
    public static void main(String[]  args) {
        Solution so = new Solution();
       System.out.println(so.minArray(new int []{4,4,4,4,2,2,3}));
        
    }
}
class Solution {
    public int minArray(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l/2 + r/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];

            }else if(nums[mid] > nums[r]){
                l = mid + 1;
                
            }else if(nums[mid] < nums[r]){
                r = mid;
            }else{r--;}
                
        }
        return nums[l];
    }
}