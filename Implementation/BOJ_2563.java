// BOJ - 2563
// Problem Sheet - https://www.acmicpc.net/problem/2563

import java.util.*;
import java.io.*;

public class Main {

    private static final int BIG_PAPER_SIZE = 100;
    private static final int SMALL_PAPER_SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[BIG_PAPER_SIZE][BIG_PAPER_SIZE];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            attachSmallPaper(paper, x, y);
        }

        int answer = 0;
        for (int i=0 ; i<BIG_PAPER_SIZE ; i++) {
            for (int j=0 ; j<BIG_PAPER_SIZE ; j++) {
                if (paper[i][j]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

        br.close();
        System.exit(0);
    }

    private static void attachSmallPaper(boolean[][] paper, int x, int y) {
        for (int i=y ; i<y+SMALL_PAPER_SIZE ; i++) {
            for (int j=x ; j<x+SMALL_PAPER_SIZE ; j++) {
                paper[i][j] = true;
            }
        }
    }
}