// BOJ - 10709
// Problem Sheet - https://www.acmicpc.net/problem/10709

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int[][] joi = new int[h][w];
        for (int i=0 ; i<h ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<w ; j++) {
                if (row.charAt(j) == 'c') joi[i][j] = 0;
                else joi[i][j] = -1;
            }
        }

        for (int i=0 ; i<h ; i++) {
            for (int j=0 ; j<w ; j++) {
                if (joi[i][j] < 0 || joi[i][j] > 0) continue;
                int s = j + 1;
                while (s < w) {
                    if (joi[i][s] == 0) break;
                    joi[i][s] = joi[i][s - 1] + 1;
                    s++;
                }
            }
        }

        for (int i=0 ; i<h ; i++) {
            for (int j=0 ; j<w ; j++) {
                sb.append(joi[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
