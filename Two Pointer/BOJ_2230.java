// BOJ - 2230
// Problem Sheet - https://www.acmicpc.net/problem/2230

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];
        for(int i=0 ; i<N ; i++) {
            sequence[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(sequence);

        int rightIndex = 1;
        int minDiff = 2000000001;
        for(int i=0 ; i<N-1 ; i++) {
            int diff = sequence[rightIndex] - sequence[i];
            while(diff < M && rightIndex < N-1) {
                diff = sequence[++rightIndex] - sequence[i];
            }
            if(diff >= M) {
                minDiff = Math.min(minDiff, diff);
            }
        }

        System.out.println(minDiff);

        bf.close();
        System.exit(0);
    }
}