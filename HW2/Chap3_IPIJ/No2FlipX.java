package OOP.HW2.Chap3_IPIJ;

import OOP.Needed_Library.Picture;

import java.awt.Color;

public class No2FlipX {

    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        int width  = pic.width();
        int height = pic.height();
        pic.show();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width / 2; x++) {
                Color c1 = pic.get(x, y);
                Color c2 = pic.get(width - x - 1, y);
                pic.set(x, y, c2);
                pic.set(width - x - 1, y, c1);
            }
        }
        pic.show();
    }
}
