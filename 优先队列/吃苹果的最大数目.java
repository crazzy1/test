package 优先队列;
import java.util.*;

public class 吃苹果的最大数目 {
    public static void main(String[] args){
        Solution5 so = new Solution5();
        System.out.println(so.eatenApples(new int[]{1,2,3,4},new int[]{2,3,4,5}));
    }
}
class Solution5 {
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) ->(a[0]-b[0]));
        int n = apples.length;
        int i = 0;
        while(i < 40002){
            while(!q.isEmpty() && q.peek()[0] <= i){
                q.poll();
            }
            if(i<n){
            int baozhiqi = i + days[i];
            int count = apples[i];
            if(count > 0){
                q.offer(new int[]{baozhiqi,count});
            }}
            if(!q.isEmpty()){
                int[] arr = q.peek();//只是引用，arr和q.peek()地址相同。
                System.out.println(q.peek()[1]);
                System.out.println(arr==(q.peek()));
                arr[1]--;
                
                if(arr[1]==0){
                    q.poll();
                }
                
                ans++;
            }
            i++;
        }
        return ans;

        
    }
}