package OOP.HW2;

public class No1ReverseString {
    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int len = str.length();
        for(int i = 0; i < len/2; i++) {
            char temp = arr[i];
            arr[i] = arr[len-i-1];
            arr[len-i-1] = temp;
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        System.out.println( reverse(args[0]));
    }
}
