package OOP.game.util;

import OOP.game.instance.Entity;

public class CollisionProcess {

    private Vector2D vec;
    private double xOffset = 0;
    private double yOffset = 0;
    private double w;
    private double h;
    private double r; // to draw circle

    private Entity entity;

    private int size;

    public CollisionProcess(Vector2D vec, int w, int h) {
        this.vec = vec;
        this.w = w;
        this.h = h;

        size = Math.max(w,h);
    }
    public CollisionProcess(Vector2D vec, int r, Entity entity) {
        this.vec = vec;
        this.r = r;
        size = r;
    }
    // getters n setters
    public Vector2D getVec() {
        return vec;
    }
    public double getRadius(){
        return r;
    }
    public double getWidth() {
        return w;
    }
    public double getHeight() {
        return h;
    }

    public void setRec(Vector2D vec, int w, int h) {
        this.vec = vec;
        this.w = w;
        this.h = h;
        size = Math.max(w,h);
    }
    public void setCircle(Vector2D vec, int r) {
        this.vec = vec;
        this.r = r;
        size = r;
    }
    public void setWidth(double temp) {
        w = temp;
    }
    public void setHeight(double temp) {
        h = temp;
    }
    public void setxOffset(double temp) {
        xOffset = temp;
    }
    public void setyOffset(double temp) {
        yOffset = temp;
    }
    public boolean collide(CollisionProcess collision) {
        double ax = (vec.getWorldVar().x + xOffset) + w/2;
        double ay = (vec.getWorldVar().y + yOffset) + h/2;
        double bx = (collision.vec.getWorldVar().x + collision.xOffset) + w/2;
        double by = (collision.vec.getWorldVar().y + collision.yOffset) + h/2;

        if(ax-bx < this.w/2 + collision.w/2 && bx-ax < this.w/2 + collision.w/2) {
            if(ay-by < this.h/2 + collision.h/2 && by-ay < this.h/2 + collision.h/2) {
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    public boolean collideCircle(CollisionProcess collision) {
        double cx = (vec.getWorldVar().x + r/Math.sqrt(2) - entity.getSize() / Math.sqrt(2));
        double cy = (vec.getWorldVar().y + r/Math.sqrt(2) - entity.getSize() / Math.sqrt(2));

        double deltaX = cx - Math.max(collision.vec.getWorldVar().x + collision.getWidth()/2, Math.min(cx, collision.vec.getWorldVar().x));
        double deltaY = cy - Math.max(collision.vec.getWorldVar().y + collision.getWidth()/2, Math.min(cy, collision.vec.getWorldVar().y));
        if(deltaX*deltaX + deltaY*deltaY < (this.r/Math.sqrt(2))*(this.r/Math.sqrt(2))) {
            return true;
        }
        return false;
    }

}
