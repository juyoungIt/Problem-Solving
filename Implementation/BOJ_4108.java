// BOJ - 4108
// Problem Sheet - https://www.acmicpc.net/problem/4108

import java.util.*;
import java.io.*;

public class Main {

    private static int[] xi = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static int[] yi = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (r ==0 && c == 0) break;
            boolean[][] isMine = new boolean[r][c];
            for (int i=0 ; i<r ; i++) {
                String row = br.readLine();
                for (int j=0 ; j<c ; j++) {
                    if (row.charAt(j) == '*') isMine[i][j] = true;
                }
            }
            for (int i=0 ; i<r ; i++) {
                for (int j=0 ; j<c ; j++) {
                    if (isMine[i][j]) {
                        sb.append("*");
                        continue;
                    }
                    int count = 0;
                    for (int k=0 ; k<8 ; k++) {
                        if (!isValid(r, c, i+yi[k], j+xi[k])) continue;
                        if (isMine[i+yi[k]][j+xi[k]]) {
                            count++;
                        }
                    }
                    sb.append(count);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isValid(int r, int c, int y, int x) {
        return y>=0 && y<r && x>=0 && x<c;
    }

}
