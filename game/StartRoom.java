package OOP.game;

import java.util.Scanner;

public class StartRoom {
    public static void main(String[] args) throws InterruptedException {
        Scanner UI = new Scanner(System.in);
        String input;
        System.out.println("The room is dark and gloomy, it reeks of dead corpses and rotten food,");
        System.out.println("You look behind you, the skeleton you recently killed and the damaged map are on the floor");
        System.out.println("the only choice no is to move forward");
        System.out.println("avail commands: forward, heal");
        input = UI.nextLine();
//        if (input.equals("heal")) {
//            player.numPotions = player.numPotions - 1;
//            p.setHP(20);
//            System.out.print("You are now at max HP, HP=" + maxHP);
//            Thread.sleep(2000);
//            new nextRoom();
//        } else if (input.equals("forward")) {
//            nextRoom();
//        } else {
//            System.out.print("Please Choose A Valid Command");
//            Thread.sleep(2000);
//            StartRoom();
//        }
    }
}
