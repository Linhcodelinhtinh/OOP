package OOP.game.graphics;

import java.awt.image.BufferedImage;

public class Animation {
    private BufferedImage[] frames;
    private int currentFrame; // index to access participle in the list "frames"
    private int numFrames;
    private int count;
    private int delay;
    private int timesPlayed; // how many times have you play the game

    public Animation(BufferedImage[] frames) {
        timesPlayed = 0;
        setFrames(frames);
    }
    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        currentFrame = 0;
        count = 0;
        timesPlayed = 0;
        delay = 2;
        numFrames = frames.length;
    }
    public void setDelay(int delay) {
        this.delay = delay;
    }
    public void setFrame(int temp){
        currentFrame = temp;
    }
    public void setNumFrames(int numFrames) {
        this.numFrames = numFrames;
    }
    public void update(){
        if(delay == -1){
            return;
        }
        count++;
        if(count == delay){
            currentFrame++;
            count = 0;
        }
        if(currentFrame == numFrames){
            currentFrame = 0;
            timesPlayed++;
        }
    }
    public int getDelay(){
        return delay;
    }
    public int getFrame(){
        return currentFrame;
    }
    public int getCount(){
        return count;
    }
    public BufferedImage getFrames(){
        return frames[currentFrame];
    }
    public boolean hasPlayedBefore(int timesPlayed){
        return (timesPlayed != 0);
    }
    public boolean hasPlayed(int temp){
        return (timesPlayed == temp);
    }
}
