// BOJ - 1654
// Problem Sheet - https://www.acmicpc.net/problem/1654

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long minCableLength = 1;
        long maxCableLength = 0;
        int[] cables = new int[K];
        for(int i=0 ; i<K ; i++) {
            cables[i] = Integer.parseInt(bf.readLine());
            if(maxCableLength < cables[i]) {
                maxCableLength = cables[i];
            }
        }

        long curCableLength;
        int cableCount;
        long optimalLength = -1;
        while(minCableLength <= maxCableLength) {
            curCableLength = (minCableLength + maxCableLength) / 2;
            cableCount = getCableCount(cables, curCableLength);
            if(cableCount >= N) {
                optimalLength = curCableLength;
                minCableLength = curCableLength + 1;
            } else {
                maxCableLength = curCableLength - 1;
            }
        }

        System.out.println(optimalLength);

        bf.close();
        System.exit(0);
    }

    private static int getCableCount(int[] cables, long unitLength) {
        int cableCount = 0;
        for(int cable : cables) {
            cableCount += cable / unitLength;
        }
        return cableCount;
    }
}