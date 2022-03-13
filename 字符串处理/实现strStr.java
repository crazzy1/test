package 字符串处理;

public class 实现strStr {
    public static void main(String[] a) {
        Solution10 so = new Solution10();
        System.out.println(so.strStr("abababba", "abb"));
    }
    
}
class Solution10 {
    // KMP算法
    public int strStr(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        if(m == 0){return 0;}
        int[] next = new int[m];
        for(int i = 1, j = 0; i < m; ++i){
            while(j>0 && pp.charAt(i) != pp.charAt(j)){
                j = next[j-1];
            }
            if(pp.charAt(i) == pp.charAt(j)){j++;}
            next[i] = j;
        }
        for(int i = 0, j = 0; i < n; ++i){
            while(j > 0 && ss.charAt(i)!=pp.charAt(j)){
                j = next[j-1];
            }
            if(ss.charAt(i) == pp.charAt(j)){j++;}
            if(j==m){return i-m+1;}
        }
        return -1;
        
    }
}

// class Solution10 {
//     // 字符串哈希
//     int P = 31;
//     int[] h, p;
//     int get(int l, int r){
//         return h[r] - h[l - 1] * p[r - l + 1];
//     }
//     public int strStr(String haystack, String needle) {
//         if(needle.length() == 0) return 0;
//         h = new int[haystack.length() + 1];
//         p = new int[haystack.length() + 1];
//         char[] str = haystack.toCharArray();
//         // char[] ptr = needle.toCharArray();
//         int hashcode = needle.hashCode();
//         p[0] = 1;
//         for(int i = 1; i <= str.length; i ++){
//             h[i] = h[i - 1] * P + str[i - 1];
//             p[i] = p[i - 1] * P;
//         }
//         for(int i = 1; i <= str.length - needle.length() + 1; i++){
//             if(hashcode == get(i, i + needle.length() - 1)) return i - 1;
//         }
//         return -1;

//     }
// }
