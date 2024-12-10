// BOJ - 32932
// Problem Sheet - https://www.acmicpc.net/problem/32932

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] map = new boolean[1001][1001];

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for (int i=0 ; i<N ; i++) {
            input = br.readLine().split(" ");
            int xi = Integer.parseInt(input[0]);
            int yi = Integer.parseInt(input[1]);
            map[yi + 500][xi + 500] = true;
        }

        int curX = 500, curY = 500;
        char[] commands = br.readLine().toCharArray();
        for (int i=0 ; i<K ; i++) {
            switch (commands[i]) {
                case 'U':
                    if (map[curY + 1][curX]) continue;
                    curY++;
                    break;
                case 'D':
                    if (map[curY - 1][curX]) continue;
                    curY--;
                    break;
                case 'R':
                    if (map[curY][curX + 1]) continue;
                    curX++;
                    break;
                case 'L':
                    if (map[curY][curX - 1]) continue;
                    curX--;
                    break;
                default:
                    throw new IllegalArgumentException("invalid command...");
            }
        }

        System.out.printf("%d %d\n", curX - 500, curY - 500);
        br.close();
    }
}