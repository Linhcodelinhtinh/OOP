package OOP.game.event;

import OOP.game.GamePanel;

import java.awt.*;


//THIS CLASS DOES NOT WORK AT THE MOMENT
public class EventHandler {
    GamePanel gamePanel;
    Rectangle eventBounds;
    int eventX, eventY;
    private int x, y;
    public EventHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        eventBounds = new Rectangle(20, 20, 8, 8 );
        eventX = eventBounds.x;
        eventY = eventBounds.y;
        x = gamePanel.player.x;
        y = gamePanel.player.y;
    }

    public void eventChecker(){
        if(x>=28*48 && x <=29*48 && y>= 14*48 && y <=15*48){
            teleport();
            System.out.println("meet event");
        }
    }
    public boolean meetEvent(int eventCol, int eventRow, String direction){
        boolean meet = false;
//        gamePanel.player.bounds.x = gamePanel.player.bounds.x;
        eventBounds.x = eventCol* gamePanel.tileSize + eventBounds.x;
        eventBounds.y = eventRow * gamePanel.tileSize + eventBounds.y;

        if(gamePanel.player.bounds.intersects(eventBounds)){
            if(gamePanel.player.direction.contentEquals(direction)|| direction.contentEquals("any")){
                meet = true;
            }
        }
        // return default value for changed variable
        gamePanel.player.bounds.x = gamePanel.player.defaultBounds.x;
        gamePanel.player.bounds.y = gamePanel.player.defaultBounds.y;
        eventBounds.x = eventX;
        eventBounds.y = eventY;

        return meet;
    }
    public void teleport(){

    }

}
