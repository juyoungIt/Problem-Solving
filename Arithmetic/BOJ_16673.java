// BOJ - 16673
// Problem Sheet - https://www.acmicpc.net/problem/16673

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int totalCollected = 0;
        for(int i=1 ; i<=C ; i++) {
            totalCollected += getCollectedCount(i, K, P);
        }

        System.out.println(totalCollected);

        bf.close();
        System.exit(0);
    }

    private static int getCollectedCount(int C, int K, int P) {
        return C * (K + C * P);
    }
}