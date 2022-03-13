import java.util.*;
public class 四数之和 {
    public static void main(String[] hhh) {
        Solution9 so = new Solution9();
        System.out.println(so.fourSum(new int[]{1,2,3,4,5,6,7,8}, 10));
        
    }
}
class Solution9 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // if(nums == null || nums.length < 4) return ans;
        // if((long) nums[0] + nums[1] + nums[2] + nums[3] > target || (long) nums[n-3] + nums[n - 4] + nums[n - 1] + nums[n - 2] < target ) return ans;
        for(int n1 = 0; n1 < n - 3; ++n1){
            if(n1>0 && nums[n1]==nums[n1-1]) continue;
            if(nums[n1] + nums[n - 3] + nums[n - 2] < target - nums[n - 1]) continue;
            if(nums[n1] + nums[n1 + 1]   > target - nums[n1 + 3] - nums[n1 + 2]) break;
            for(int n2 = n1 + 1; n2 < n - 2; ++n2){
                if(n2>n1+1 && nums[n2]==nums[n2-1]) continue;
                // if(nums[n1] + nums[n - 3] + nums[n - 2] < target - nums[n - 1]) continue;
                // if(nums[n1] + nums[n1 + 1]   > target - nums[n1 + 3] - nums[n1 + 2]) break;
                int n3 = n2 + 1, n4 = n - 1;
                while(n3 < n4){
                    if(nums[n1]+nums[n2]+nums[n3]<target-nums[n4]){
                        n3++;
                    }else if(nums[n1]+nums[n2]+nums[n3]>target-nums[n4]){
                        n4--;
                    }else{
                        ans.add(Arrays.asList(nums[n1],nums[n2],nums[n3],nums[n4]));
                        while(n3<n4 && nums[n3] == nums[n3+1]) n3++;
                        while(n3<n4 && nums[n4] == nums[n4-1]) n4--;
                        n3++;
                        n4--;
                    }
                }
            }
        }
        return ans;
    }
}