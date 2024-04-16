package OOP.HW2;

import OOP.Needed_Library.Picture;

import java.awt.*;
public class No3ColourSeparation {
    public static void main(String[] args) {

        // read in the picture specified by command-line argument
        Picture picture = new Picture(args[0]);
        int width = picture.width();
        int height = picture.height();

        // create three blank pictures of the same dimension
        Picture pictureR = new Picture(640, 1080);
        Picture pictureG = new Picture(1280, 1080);
        Picture pictureB = new Picture(1920, 1080);

        // separate colors
        for (int col = 0; col < width/3; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);
                int r = color.getRed();
                //int g = color.getGreen();
                //int b = color.getBlue();
                pictureR.set(col, row, new Color(r, 0, 0));
                //pictureG.set(col, row, new Color(0, g, 0));
                //pictureB.set(col, row, new Color(0, 0, b));
            }
        }
        for (int col = width/3 +1; col < 2*width/3; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);
                //int r = color.getRed();
                int g = color.getGreen();
                //int b = color.getBlue();
                //pictureR.set(col, row, new Color(r, 0, 0));
                pictureG.set(col, row, new Color(0, g, 0));
                //pictureB.set(col, row, new Color(0, 0, b));
            }
        }
        for (int col = 2*width/3 +1; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);
                //int r = color.getRed();
                //int g = color.getGreen();
                int b = color.getBlue();
                //pictureR.set(col, row, new Color(r, 0, 0));
                //pictureG.set(col, row, new Color(0, g, 0));
                pictureB.set(col, row, new Color(0, 0, b));
            }
        }

        // display each picture in its own window
        pictureR.show();
        pictureG.show();
        pictureB.show();
    }
}
