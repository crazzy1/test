package 字符串处理;
// hard   二分 + 字符串哈希
import java.util.HashMap;
// import java.util.function.LongToDoubleFunction;

public class 最长重复子串 {
    public static void main(String[] args){
        Solution so = new Solution();
        System.out.println(so.longestDupSubstring("banan"));
    }
}
class Solution {
    long[] h , p;
    public String longestDupSubstring(String s){
        String ans = "";
        int P = 1313, n = s.length();
        
        h = new long[n+10]; p = new long[n+10];
        p[0] = 1;
        for(int i = 0; i < n; ++i){
            p[i+1] = p[i] * P;
            h[i+1] = h[i] * P + s.charAt(i);
        }
        int l = 0 , r = n;
        while(l < r){
            int mid = l/2 + r/2;
            String now = check(s,mid);
            if(now.length() != 0){
                l = mid + 1; 
            }else r = mid;
            ans = now.length() > ans.length() ? now : ans;
        }
        return ans;
    }
    public String check(String s, int len){
        int n = s.length();
        HashMap<Long,Integer> map = new HashMap<>();
        for(int i = 1; i + len -1 <= n; ++i){
            int j = i + len - 1;
            long cur = h[j] - h[i - 1] * p[len];
            int now = map.getOrDefault(cur, 0);
            if(now == 1){
                return s.substring(i-1, j);
            }
            map.put(cur,now+1);
        }
        return "";
    }
}