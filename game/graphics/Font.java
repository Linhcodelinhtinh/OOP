package OOP.game.graphics;

import OOP.game.util.Vector2D;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;


public class Font {
    private final int TILE_SIZE = 32;
    public int w;
    public int h;
    private /*final*/ BufferedImage FONTSHEET = null;
    private BufferedImage[][] spriteArray;
    private int wLetter; // total number of columns
    private int hLetter; // total number of rows

    public Font(String fileName) {
        w = TILE_SIZE;
        h = TILE_SIZE;

        System.out.println("Loading " + fileName);
        FONTSHEET = loadSprite(fileName);
        wLetter = FONTSHEET.getWidth() / w;
        hLetter = FONTSHEET.getHeight() / h;
        loadSpriteArray();
    }

    public Font(String fileName, int w, int h) {
        this.w = w;
        this.h = h;

        System.out.println("Loading " + fileName);
        FONTSHEET = loadSprite(fileName);
        wLetter = FONTSHEET.getWidth() / w;
        hLetter = FONTSHEET.getHeight() / h;
        loadSpriteArray();
    }

    public static void drawArray(Graphics2D g, ArrayList<BufferedImage> image, Vector2D vec, int width, int height, int xOffset, int yOffset) {
        double x = vec.x;
        double y = vec.y;
        for (BufferedImage bufferedImage : image) {
            if (bufferedImage != null) {
                g.drawImage(bufferedImage, (int) x, (int) y, width, height, null);
            }
            x += xOffset;
            y += yOffset;
        }
    }

    public static void drawArray(Graphics2D g, java.awt.Font f, String word, Vector2D vec, int width, int height, int xOffset, int yOffset) {
        double x = vec.x;
        double y = vec.y;
//        for (char c : word.toCharArray()) {
//            if (c != 32) {
//                g.drawImage(f.getFont(c), (int) x, (int) y, width, height, null);
//            }
//            x += xOffset;
//            y += yOffset;
//        }
    }

    public void setSize(int w, int h) {
        setWidth(w);
        setHeight(h);
    }

    public int getWidth() {
        return w;
    }

    public void setWidth(int temp) {
        w = temp;
        wLetter = FONTSHEET.getWidth() / w;
    }

    public int getHeight() {
        return h;
    }

    public void setHeight(int temp) {
        h = temp;
        hLetter = FONTSHEET.getHeight() / h;
    }

    private BufferedImage loadSprite(String fileName) {
        BufferedImage font = null;
        try {
            font = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName)));
        } catch (Exception e) {
            System.out.println("Couldn't load " + fileName);
        }
        return font;
    }

    public void loadSpriteArray() {
        spriteArray = new BufferedImage[wLetter][hLetter];
        for (int x = 0; x < wLetter; x++) {
            for (int y = 0; y < hLetter; y++) {
                spriteArray[x][y] = getLetter(x, y);
            }
        }
    }

    public BufferedImage getFontSheet() {
        return FONTSHEET;
    }

    public BufferedImage getLetter(int x, int y) {
        return FONTSHEET.getSubimage(x * w, y * h, w, h);
    }

}
