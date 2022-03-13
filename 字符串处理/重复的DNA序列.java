package 字符串处理;
//  mid 字符串哈希
import java.util.*;


public class 重复的DNA序列 {
    public static void main(String[] args){
        Solution4 so = new Solution4();
        System.out.println(so.findRepeatedDnaSequences("AAAAAAAAAAAABBBBBBBBBBBBAAAAAAAAAAAABBBBBBBBBBBBBB"));
    }
}
class Solution4 {
    int len = 10;
    int N = (int)1e5+10, P = 131313;
    int[] h = new int[N], p = new int[N];
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i + len - 1 <= n; i++) {
            int j = i + len - 1;
            int hash = h[j] - h[i - 1] * p[len];
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1) ans.add(s.substring(i - 1, i + len - 1));
            map.put(hash, cnt + 1);
        }
        return ans;
    }
}
