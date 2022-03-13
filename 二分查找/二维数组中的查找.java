package 二分查找;

public class 二维数组中的查找 {
    public static void main(String[] args){
        Solution3 so = new Solution3();
        System.out.println(so.findNumberIn2DArray(new int[][]{{1,2,3,4},{5,7,8,9},{10,11,12,13}}, 6));
    } 
}
class Solution3 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        
        while(i>=0 && j < matrix[0].length){
            System.out.println(""+i+j);
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                i--;
            }else{j++;}
        }
        return false;
    }
}