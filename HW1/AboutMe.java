package OOP.HW1;

import OOP.Needed_Library.StdOut;

public class AboutMe {
    public static void main(String[] args) {
        System.out.println("Họ và tên: Lưu Quang Linh.\tMSSV: 23020392 \tLớp: K68AI2 \tUsername: Linhcodelinhtinh\tEmail: 23020392@vnu.edu.vn");
        for(int i = 9; i > 0; i--) {
            System.out.println(i + " bottles of beer on the wall, " + i +" bottles of beer.\n" +
                    "Take one down, pass it around,");
        }
        StdOut.println("No more bottles of beer on the wall.");
    }
}
