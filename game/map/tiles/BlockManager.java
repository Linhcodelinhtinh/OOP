package OOP.game.map.tiles;

import OOP.game.GamePanel;
import OOP.game.util.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class BlockManager {
    GamePanel gamePanel;
    public Block[] blocks;
    public int[][] mapBlocksNum;

    public BlockManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        blocks = new Block[16];// 16 is the number of needed type of tile. ex: grass, water, wall, ...
        getBlockImage();
        mapBlocksNum = new int[gamePanel.screenCol][gamePanel.screenRow];
        loadMap("/OOP/game/resources/maps/map1.txt");
    }
    public void loadMap(String fileName){
        try{
            InputStream is = Objects.requireNonNull(getClass().getResourceAsStream(fileName));
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while(col< gamePanel.screenCol && row< gamePanel.screenRow){
                String line = reader.readLine();
                while(col < gamePanel.screenCol){
                    String[] tokens = line.split(" "); // split each number into a mini string
                    int temp = Integer.parseInt(tokens[col]); // convert mini string to integer
                    mapBlocksNum[col][row] = temp; // add that integer to the matrix that represent for map
//                    System.out.println("Col: " + col);
                    col++;
                }
                if(col == gamePanel.screenCol){
                    col = 0;
//                    System.out.println("row: " + row);
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
            for(int i = 0; i < 16; i++) {
                blocks[i] = new Block();
            }
            blocks[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/OOP/game/resources/blocks/tile.png")));
            blocks[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/OOP/game/resources/blocks/wall.png")));
            blocks[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/OOP/game/resources/blocks/tile2.png")));
            blocks[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/OOP/game/resources/blocks/wall2.png")));
            blocks[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/OOP/game/resources/blocks/tile4.png")));
            blocks[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/OOP/game/resources/blocks/tile3.png")));
            blocks[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/OOP/game/resources/blocks/left_wall.png")));
            blocks[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/OOP/game/resources/blocks/right_wall.png")));
            blocks[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/OOP/game/resources/blocks/tile5.png")));

            blocks[1].isCollide = true;
            blocks[3].isCollide = true;
            blocks[6].isCollide = true;
            blocks[7].isCollide = true;

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
            if(blockNum == 4){
                g2d.drawImage(blocks[4].image, x, y, size, size, null);
            //    g2d.drawImage(blocks[blockNum].image, x, y, size, size, null);
            }
            else {
                g2d.drawImage(blocks[blockNum].image, x, y, size, size, null);
            }
            col++;
            x += size;
            if(col == gamePanel.screenCol){
                col = 0;
                x = 0;
                row++;
                y+= size;
            }
        }
    }
}
