// BOJ - 17136
// Problem Sheet - https://www.acmicpc.net/problem/17136

import java.io.*;

public class Main {

    private static final int[][] paper = new int[10][10];
    private static int minUsedPaperCount = 26;
    private static int[] papers = { 0, 5, 5, 5, 5, 5 };
    private static int nextX, nextY;

    public static void main(String[] args) throws IOException {
        input();
        findNext(0);
        solve(nextX, nextY, 0);
        System.out.println(minUsedPaperCount != 26 ? minUsedPaperCount : -1);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0 ; i<10 ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<10 ; j++) {
                paper[i][j] = Integer.parseInt(row[j]);
            }
        }
        br.close();
    }

    private static void solve(int startX, int startY, int count) {
        if (startX == -1 && startY == -1) {
            minUsedPaperCount = Math.min(minUsedPaperCount, count);
            return;
        }
        if (count >= minUsedPaperCount) {
            return;
        }
        for (int size=1 ; size<=5 ; size++) {
            if (papers[size] == 0 || !isPlaceable(startX, startY, size)) continue;
            put(startX, startY, size);
            papers[size]--;
            findNext(startY);
            solve(nextX, nextY, count + 1);
            papers[size]++;
            remove(startX, startY, size);
        }
    }

    private static boolean isPlaceable(int leftTopX, int leftTopY, int size) {
        if (leftTopX + size > 10 || leftTopY + size > 10) {
            return false;
        }
        for (int i=leftTopY ; i<leftTopY + size ; i++) {
            for (int j=leftTopX ; j<leftTopX + size ; j++) {
                if (paper[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void put(int leftTopX, int leftTopY, int size) {
        for (int i=leftTopY ; i<leftTopY + size ; i++) {
            for (int j=leftTopX ; j<leftTopX + size ; j++) {
                paper[i][j] = 0;
            }
        }
    }

    private static void remove(int leftTopX, int leftTopY, int size) {
        for (int i=leftTopY ; i<leftTopY + size ; i++) {
            for (int j=leftTopX ; j<leftTopX + size ; j++) {
                paper[i][j] = 1;
            }
        }
    }

    private static void findNext(int lastY) {
        for (int i=lastY ; i<10 ; i++) {
            for (int j=0 ; j<10 ; j++) {
                if (paper[i][j] == 1) {
                    nextX = j;
                    nextY = i;
                    return;
                }
            }
        }
        nextX = -1;
        nextY = -1;
    }
}
