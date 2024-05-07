package OOP.HW1;

import OOP.Needed_Library.StdDraw;

public class RandomWalk {


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        int direction = 0;
        int count = 1;
        int sideLength = 1;

        while (Math.abs(x)<n && Math.abs(y)<n) {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(x, y, 0.45);
            steps++;

            if (direction == 0) {
                x++;
            } else if (direction == 1) {
                y++;
            } else if (direction == 2) {
                x--;
            } else if (direction == 3) {
                y--;
            }

            count++;
            if (count > sideLength) {
                direction = (direction + 1) % 4;
                count = 1;
                if (direction == 0 || direction == 2) {
                    sideLength++;
                }
            }

            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledSquare(x, y, 0.45);
            StdDraw.show();
            StdDraw.pause(40);
        }
        System.out.println("Total steps = " + steps);
    }
}
