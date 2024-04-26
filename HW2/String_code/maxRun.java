package OOP.HW2.String_code;

import java.util.Scanner;

import static java.lang.Math.max;

public class maxRun {
    public static int max_Run(String str){
        int count = 1, maxCount = 1;
        str = str + "?";
        char[] chars = str.toCharArray();
        for(int i=0;i<str.length() - 1;i++){
            if(chars[i]==chars[i+1]){
                count++;
            }
            else {
                maxCount = max(maxCount, count);
                count = 1;
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(max_Run(str));
    }
}
