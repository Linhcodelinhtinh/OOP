package OOP.HW2.String_code;

import java.util.Scanner;

public class Blowup {
    public static String blowup(String str){
        char[] arr = str.toCharArray();
        String s = "";
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= 48 && arr[i] <= 57) {
                for (int j = 0; j < arr[i] - 48; j++) {
                    s += arr[i+1];
                }
            }
            else
                s += arr[i];
        }
        if (arr[arr.length-1] >= 48 && arr[arr.length-1] <= 57){
            s+= "";
        }
        else
            s+= arr[arr.length-1];
        return s;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(blowup(str));
    }
}