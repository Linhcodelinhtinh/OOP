package OOP.temp.util;

public class Vector2D {

    public double x;
    public double y;

    public static double worldX;
    public static double worldY;

    public Vector2D() {
        x = 0;
        y = 0;
    }
    public Vector2D (Vector2D v) {
        new Vector2D(v.x, v.y);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // kinda like getter n setter
    public void addX(double d) {
        x += d;
    }
    public void addY(double d) {
        y += d;
    }

    public void setX(double d) {
        x = d;
    }
    public void setY(double d) {
        y = d;
    }
    public void setVector(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }
    public void setVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static void setWorldVar(double x, double y) {
        worldX = x;
        worldY = y;
    }
    public Vector2D getWorldVar() {
        return new Vector2D(x - worldX, y - worldY);
    }

    @Override
    public String toString() {
        return "Vector2D [x=" + x + ", y=" + y + "]";
    }
}
