package OOP.game.map;

import OOP.game.GamePanel;
import OOP.game.instance.Entity;

public class Collision {

    GamePanel gamePanel;
    public Collision(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void checkCollision(Entity entity){
        int leftBorder = entity.x + entity.bounds.x;
        int rightBorder = entity.x + entity.bounds.x + entity.bounds.width;
        int topBorder = entity.y + entity.bounds.y;
        int bottomBorder = entity.y + entity.bounds.y + entity.bounds.height - 2;

        int leftCol = leftBorder/ gamePanel.tileSize;
        int rightCol = rightBorder/ gamePanel.tileSize;
        int topRow = topBorder/ gamePanel.tileSize;
        int bottomRow = bottomBorder/ gamePanel.tileSize;

        int blockNum1, blockNum2;

        switch (entity.direction){
            case "up":
                topRow = (topBorder - entity.speed)/ gamePanel.tileSize;
                blockNum1 = gamePanel.blockManager.mapBlocksNum[leftCol][topRow]; // check if the top left of character hit any obstacles
                blockNum2 = gamePanel.blockManager.mapBlocksNum[rightCol][topRow];//check if the top right of character hit any obstacles
                if(gamePanel.blockManager.blocks[blockNum1].isCollide || gamePanel.blockManager.blocks[blockNum2].isCollide){
                    entity.collide = true;
                }
                break;
            case "down":
                bottomRow = (bottomBorder + entity.speed)/ gamePanel.tileSize;
                blockNum1 = gamePanel.blockManager.mapBlocksNum[leftCol][bottomRow];
                blockNum2 = gamePanel.blockManager.mapBlocksNum[rightCol][bottomRow];
                if(gamePanel.blockManager.blocks[blockNum1].isCollide || gamePanel.blockManager.blocks[blockNum2].isCollide){
                    entity.collide = true;
                }
                break;
            case "left":
                leftCol = (leftBorder - entity.speed)/ gamePanel.tileSize;
                blockNum1 = gamePanel.blockManager.mapBlocksNum[leftCol][topRow];
                blockNum2 = gamePanel.blockManager.mapBlocksNum[leftCol][bottomRow];
                if(gamePanel.blockManager.blocks[blockNum1].isCollide || gamePanel.blockManager.blocks[blockNum2].isCollide){
                    entity.collide = true;
                }
                break;
            case "right":
                rightCol = (rightBorder + entity.speed)/ gamePanel.tileSize;
                blockNum1 = gamePanel.blockManager.mapBlocksNum[rightCol][topRow];
                blockNum2 = gamePanel.blockManager.mapBlocksNum[rightCol][bottomRow];
                if(gamePanel.blockManager.blocks[blockNum1].isCollide || gamePanel.blockManager.blocks[blockNum2].isCollide){
                    entity.collide = true;
                }
                break;

        }
    }
}
