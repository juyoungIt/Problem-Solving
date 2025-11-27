// BOJ - 28463
// Problem Sheet - https://www.acmicpc.net/problem/28463

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char direction = br.readLine().charAt(0);
        char[][] grid = new char[2][2];
        String row = br.readLine();
        grid[0][0] = row.charAt(0);
        grid[0][1] = row.charAt(1);
        row = br.readLine();
        grid[1][0] = row.charAt(0);
        grid[1][1] = row.charAt(1);
        br.close();
        if (direction == 'W') {
            if (grid[1][1] == '.' && grid[0][1] == 'I' && grid[1][0] == 'P' && grid[0][0] == '.') System.out.println("F");
            else if (grid[1][1] == 'O' && grid[0][1] == '.' && grid[1][0] == '.' && grid[0][0] == 'P') System.out.println("T");
            else if (grid[1][1] == '.' && grid[0][1] == 'O' && grid[1][0] == 'P' && grid[0][0] == '.') System.out.println("Lz");
            else System.out.println("?");
        } else if (direction == 'E') {
            if (grid[0][0] == '.' && grid[1][0] == 'I' && grid[0][1] == 'P' && grid[1][1] == '.') System.out.println("F");
            else if (grid[0][0] == 'O' && grid[1][0] == '.' && grid[0][1] == '.' && grid[1][1] == 'P') System.out.println("T");
            else if (grid[0][0] == '.' && grid[1][0] == 'O' && grid[0][1] == 'P' && grid[1][1] == '.') System.out.println("Lz");
            else System.out.println("?");
        } else if (direction == 'N') {
            if (grid[1][0] == '.' && grid[1][1] == 'I' && grid[0][0] == 'P' && grid[0][1] == '.') System.out.println("F");
            else if (grid[1][0] == 'O' && grid[1][1] == '.' && grid[0][0] == '.' && grid[0][1] == 'P') System.out.println("T");
            else if (grid[1][0] == '.' && grid[1][1] == 'O' && grid[0][0] == 'P' && grid[0][1] == '.') System.out.println("Lz");
            else System.out.println("?");
        } else {
            if (grid[0][1] == '.' && grid[0][0] == 'I' && grid[1][1] == 'P' && grid[1][0] == '.') System.out.println("F");
            else if (grid[0][1] == 'O' && grid[0][0] == '.' && grid[1][1] == '.' && grid[1][0] == 'P') System.out.println("T");
            else if (grid[0][1] == '.' && grid[0][0] == 'O' && grid[1][1] == 'P' && grid[1][0] == '.') System.out.println("Lz");
            else System.out.println("?");
        }
    }
}
