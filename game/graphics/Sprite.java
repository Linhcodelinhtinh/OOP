//package OOP.game.graphics;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.util.ArrayList;
//import java.util.Objects;
//
//public class Sprite {
//
//    private final BufferedImage SPRITESHEET = null;
//    private BufferedImage [][] spriteArray;
//    private final int TILE_SIZE = 32;
//    public int w;
//    public int h;
//    private int wSprite; // total number of columns
//    private int hSprite; // total number of rows
//
//    public Sprite(String fileName) {
//        w = TILE_SIZE;
//        h = TILE_SIZE;
//
//        System.out.println("Loading " + fileName);
//        SPRITESHEET = loadSprite(fileName);
//        wSprite = SPRITESHEET.getWidth()/w;
//        hSprite = SPRITESHEET.getHeight()/h;
//        loadSpriteArray();
//    }
//
//    public Sprite(String fileName, int w, int h) {
//        this.w = w;
//        this.h = h;
//
//        System.out.println("Loading " + fileName);
//        SPRITESHEET = loadSprite(fileName);
//        wSprite = SPRITESHEET.getWidth()/w;
//        hSprite = SPRITESHEET.getHeight()/h;
//        loadSpriteArray();
//    }
//    public void setSize(int w, int h) {
//        setWidth(w);
//        setHeight(h);
//    }
//    public void setWidth(int temp) {
//        w = temp;
//        wSprite = SPRITESHEET.getWidth()/w;
//    }
//    public void setHeight(int temp) {
//        h = temp;
//        hSprite = SPRITESHEET.getHeight()/h;
//    }
//    public int getWidth(){
//        return w;
//    }
//    public int getHeight(){
//        return h;
//    }
//    private BufferedImage loadSprite(String fileName) {
//        BufferedImage sprite = null;
//        try{
//            sprite = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName)));
//        } catch(Exception e){
//            System.out.println("Couldn't load " + fileName);
//        }
//        return sprite;
//    }
//    public void loadSpriteArray() {
//        spriteArray = new BufferedImage[wSprite][hSprite];
//        for (int x = 0; x < wSprite; x++) {
//            for (int y = 0; y < hSprite; y++) {
//                spriteArray[x][y] = getSprite(x,y);
//            }
//        }
//    }
//
//    public BufferedImage getSpriteSheet(){
//        return SPRITESHEET;
//    }
//    public BufferedImage getSprite(int x, int y) {
//        return SPRITESHEET.getSubimage(x * w, y * h, w, h);
//    }
//    public BufferedImage[] getSpriteArray(int index) {
//        return spriteArray[index];
//    }
//    public BufferedImage getSpriteArray(int x, int y) {
//        return spriteArray[x][y];
//    }
//    public static void drawArray(Graphics2D g, ArrayList<BufferedImage> image, Vector2f position, int width, int height, int xOffset, int yOffset) {
//        float x = position.x;
//        float y = position.y;
//        for (int i = 0; i < image.size(); i++) {
//            if(image.get(i) != null){
//                g.drawImage(image.get(i),(int) x, (int) y, width, height, null);
//            }
//            x += xOffset;
//            y += yOffset;
//
//
//        }
//    }
//}
