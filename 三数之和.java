import java.util.*;
public class 三数之和 {
    public static void main(String[] args) {
        Solution8 so = new Solution8();
        System.out.println(so.threeSum(new int[]{-1,-2,-3,-1,1,2,3}));
    }
}
class Solution8 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int l = 0; l < n - 2; ++l){
            if(nums[l] > 0){
                return ans;
            }
            if(l > 0 && nums[l - 1] == nums[l]){
                continue;
            }
            int m = l + 1, r = n - 1;
            while(m < r){
                if(nums[l] + nums[m] > -nums[r]){
                    // while(r > 0 && nums[r] == nums[r-1])r--;
                    r--;
                }else if(nums[l] + nums[m] < -nums[r]){
                    // while(m + 1 < n && nums[m] == nums[m+1])m++;
                    m++;
                }else{
                    ans.add(Arrays.asList(nums[l],nums[m],nums[r]));
                    while(m < r && nums[m] == nums[m+1])m++;
                    m++;
                    while(r > m && nums[r] == nums[r-1])r--;
                    r--;
                }
            }
            
        }
        // String[] a = new String[]{"!","a","cascas"};
        // System.out.println(Arrays.asList(a));
        return ans;
    }
}