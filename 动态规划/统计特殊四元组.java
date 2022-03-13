package 动态规划;
public class 统计特殊四元组{
    public static void main(String[] args){
        Solution7 so = new Solution7();
        System.out.println(so.countQuadruplets(new int[]{1,2,3,6,10}));
    }
}
// 由于顺序的序列才被接收，所以需要在每一步dp更新之前更新ans
class Solution7 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[101];
        int[] dp2 = new int[101];
        int[] dp3 = new int[101];
        int ans = 0;
        for(int i = 0; i < n; ++i){
            int x = nums[i];
            ans += dp3[x];
            if(i>=2){
                for(int j = 1; j <= 100 - x; ++j){
                    dp3[x + j] += dp2[j];
                }
            }
            if(i>=1){
                for(int j = 1; j <= 100 - x; ++j){
                    dp2[x + j] += dp1[j];
                }
            }
            dp1[x]++;
        }
        return ans;
    }
}