// BOJ - 30889
// Problem Sheet - https://www.acmicpc.net/problem/30889

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] seats = new boolean[10][21];
        while (n-- > 0) {
            String seatInfo = br.readLine();
            char row = seatInfo.charAt(0);
            int number = Integer.parseInt(seatInfo.substring(1));
            seats[row - 'A'][number] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : seats) {
            for (int i=1 ; i<row.length ; i++) {
                sb.append(row[i] ? 'o' : '.');
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
