// BOJ - 14465
// Problem Sheet - https://www.acmicpc.net/problem/14465

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int currentBrokenCount = 0;
        boolean[] brokens = new boolean[N+1];
        for(int i=0 ; i<B ; i++) {
            int index = Integer.parseInt(bf.readLine());
            brokens[index] = true;
            if(index <= K && brokens[index]) {
                currentBrokenCount++;
            }
        }

        int leftIndex = 1;
        int rightIndex = K;
        int minRepairCount = 100000;
        while(rightIndex <= N) {
            minRepairCount = Math.min(minRepairCount, currentBrokenCount);
            if(brokens[leftIndex++]) {
                currentBrokenCount--;
            }
            if(++rightIndex <= N && brokens[rightIndex]) {
                currentBrokenCount++;
            }
        }

        System.out.println(minRepairCount);

        bf.close();
        System.exit(0);
    }
}