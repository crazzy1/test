import java.util.*;

import javax.print.DocFlavor.STRING;
public class test {
    public static void main(String[] args) {
        Solution8 so = new Solution8();
        System.out.println(so.t("asd");
    }
}
class Solution100 {
    public String t(String a) {
        char[] cs = a.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char i : cs){
            if(Character.isLetter(i)){
                sb.append(i);
            }else if(i == '<' || i == '>' || i == '='){
                sb.append(' ');
                sb.append(i);
                sb.append(' ');
            }

        }
        return sb.toString().trim();


    }
}