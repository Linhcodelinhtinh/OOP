package OOP.HW2;

import java.util.Scanner;
import java.util.HashSet;

public class StringIntersect {
    public static boolean stringIntersect(String a, String b, int len){
        HashSet<String> h = new HashSet<>();
        for(int i=0; i<a.length(); i++){
            h.add(a.substring(i,i+len));
        }
        for(int i=0; i<b.length(); i++){
            if(h.contains(b.substring(i,i+len)))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int len = sc.nextInt();
        System.out.println(stringIntersect(a, b, len));
    }
}
