package OOP.HW2;

import OOP.HW1.StdOut;

import java.awt.*;

public class Luminance {
    public static double lum(Color rgb) {
        //read n value
        int r = rgb.getRed();
        int g = rgb.getGreen();
        int b = rgb.getBlue();
        return .299 * r + .587 * g + .114 * b;
    }
    public static void main(String[] args ) {
        int r = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        Color rgb = new Color(r, g, b);
        //System.out.println(lum(rgb));
        StdOut.println(lum(rgb));
    }
}