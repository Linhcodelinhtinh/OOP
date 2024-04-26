package OOP.HW2.CharGrid;

import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class CharArea {
    static char[][] grid = new char[1000][1000];

    static int charArea(char ch){
        int col_max = -1, col_min = MAX_VALUE, row_max = -1, row_min = MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
//                    System.out.println(i + " " + j);
                    col_max = Math.max(col_max, j);
                    col_min = Math.min(col_min, j);
                    row_max = Math.max(row_max, i);
                    row_min = Math.min(row_min, i);
                }
            }
        }
        return (col_max - col_min +1) * (row_max- row_min+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char current_ch = sc.next().charAt(0);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = sc.next().charAt(0);
            }
        }
        System.out.println(charArea(current_ch));
    }
}
