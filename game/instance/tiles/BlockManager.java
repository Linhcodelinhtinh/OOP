package OOP.game.instance.tiles;

import OOP.game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BlockManager {
    GamePanel gamePanel;
    Block[] blocks;
    int[][] mapBlocksNum;

    public BlockManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        blocks = new Block[16];// 16 is the number of needed type of tile. ex: grass, water, wall, ...
        getBlockImage();
        mapBlocksNum = new int[gamePanel.screenCol][gamePanel.screenRow];
        loadMap("OOP/game/resources/maps/map1.txt");
    }
    public void loadMap(String fileName){
        try{
            InputStream in = getClass().getResourceAsStream(fileName);
            assert in != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            int col = 0;
            int row = 0;
            while(col< gamePanel.screenCol && row< gamePanel.screenRow){
                String line = reader.readLine();
                while(col < gamePanel.screenCol){
                    String[] tokens = line.split(" "); // split each number into a mini string
                    int temp = Integer.parseInt(tokens[col]); // convert mini string to integer
                    mapBlocksNum[row][col] = temp; // add that integer to the matrix that represent for map
                    col++;
                }
                if(col == gamePanel.screenCol){
                    col = 0;
                    row++;
                }
            }
            System.out.println("file loaded successfully");
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void getBlockImage(){
        try{
            blocks[0] = new Block();
            blocks[0].image = ImageIO.read(getClass().getResource("/OOP/game/resources/blocks/tile.png"));

            blocks[1] = new Block();
            blocks[1].image = ImageIO.read(getClass().getResource("/OOP/game/resources/blocks/wall.png"));

            blocks[2] = new Block();
            blocks[2].image = ImageIO.read(getClass().getResource("/OOP/game/resources/blocks/tile2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2d){
        int size = gamePanel.tileSize;
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        int blockNum;
        while(col < gamePanel.screenCol && row < gamePanel.screenRow){
            blockNum = mapBlocksNum[col][row];
            g2d.drawImage(blocks[blockNum].image, x, y, size, size, null);
            col++;
            x += size;
            if(col == gamePanel.screenCol){
                col = 0;
                x = 0;
                row++;
                y+= size;
            }
        }
//        g2d.drawImage(blocks[0].image,0,0, gamePanel.tileSize,gamePanel.tileSize,null);
//        g2d.drawImage(blocks[1].image,48,1, gamePanel.tileSize,gamePanel.tileSize,null);
//        g2d.drawImage(blocks[2].image,96,2, gamePanel.tileSize,gamePanel.tileSize,null);
    }
}
