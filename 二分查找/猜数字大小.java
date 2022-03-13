package 二分查找;
public class 猜数字大小 {
    public static void main(String[]  args) {
        Solution1 so = new Solution1();
       System.out.println(so.solve( 50,100 ));
        
    }
}
class Solution1 {
    int tar;
    public int  guess(int n){
        if(n > tar){return 1;}
        else if(n < tar){return -1;}
        return 0;
    }
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while(l<=r){
            int mid = l + (r - l) / 2;
            int flag = this.guess(mid);
            if(flag == 0){
                return mid;
            }else if (flag == 1){
                l = mid + 1 ;
            }else{
                r = mid - 1 ; 
            }
        }
        return 0;
    }
    public int solve(int tar, int border){
        this.tar = tar;
        return guessNumber(border);
    }
}