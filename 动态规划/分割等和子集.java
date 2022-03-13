package 动态规划;

public class 分割等和子集 {
    public static void main(String[] args) {
        Solution8 so = new Solution8();
    System.out.println(so.canPartition(new int[]{1,2,3,-2,-3,1}));
    }
    
}
class Solution8 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        int target = sum/2;
        if(target*2 != sum){
            return false;
        }
        boolean[] dp = new boolean[target+100];//加大dp数组的范围，即可处理负数情况（因为target加负数后变小，中间变量先变大再变小成target，变大时会越界）
        dp[0] = true;
        for(int i = 0; i < n; ++i){
            int t = nums[i];
            for(int j = target; j >=0; --j){
                boolean no = dp[j];
                boolean yes = j>=t ? dp[j-t] : false;
                dp[j] = no || yes;
                if(j == target && yes == true) return true;
            }
        }
        return dp[target];
    }
}