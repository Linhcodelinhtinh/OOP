package OOP.game;
import java.util.Scanner;

public class game_play {
    public static void main(String[] args) throws InterruptedException {
        Scanner UI = new Scanner(System.in);
        String name = "";
        int maxHP = 20;
        int potion = 3;
        player p = new player(20, 20, 0);

        System.out.println("Welcome To Dungeon Maze");
        System.out.println("Please Input Your Name ");
        player.name = UI.nextLine();
        System.out.print(player.name +" is a brave adventurer");
        System.out.println("");
        Thread.sleep(3000);
        System.out.println("They were sent on a task to check on one of");
        Thread.sleep(3000);
        System.out.println("the sacred underground shrines of Port Nyanzaru,");
        Thread.sleep(3000);
        System.out.format("but when one of the skeletons knocked off the map %s had,", name);
        System.out.println("");
        Thread.sleep(3000);
        System.out.println("they had no choice but to try and escape the dungeon");
        Thread.sleep(3000);
        System.out.println("ARE YOU READY BRAVE ADVENTURER");
        p.setHP(maxHP);
        player.lvl = 1;
        player.def = 1;
        player.atk = 1;
        Thread.sleep(5000);

    }
}
