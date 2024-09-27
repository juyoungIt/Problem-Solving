// BOJ - 1895
// Problem Sheet - https://www.acmicpc.net/problem/1895

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] image = new int[r][c];
        int[][] filtered = new int[r-2][c-2];
        for (int i=0 ; i<r ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<c ; j++) {
                image[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t = Integer.parseInt(br.readLine());

        for (int i=0 ; i<r-2 ; i++) {
            for (int j=0 ; j<c-2 ; j++) {
                filtered[i][j] = getSectionMedian(image, j, i);
            }
        }

        int answer = 0;
        for (int[] row : filtered) {
            for (int value : row) {
                if (value >= t) {
                    answer++;
                }
            }
        }
        System.out.println(answer);

        br.close();
        System.exit(0);
    }

    private static int getSectionMedian(int[][] image, int startX, int startY) {
        int[] values = new int[9];
        int index = 0;
        for (int i = startY ; i<startY+3 ; i++) {
            for (int j = startX ; j<startX+3 ; j++) {
                values[index++] = image[i][j];
            }
        }
        Arrays.sort(values);
        return values[4];
    }
}