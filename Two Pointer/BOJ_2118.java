// BOJ - 2118
// Problem Sheet - https://www.acmicpc.net/problem/2118

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int totalDist = 0;
        for(int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            totalDist += arr[i];
        }

        int maxDist = 0;
        int pairIndex = -1;
        int clockwistDist = 0;
        for(int i=0 ; i<N ; i++) {
            while(totalDist - clockwistDist > clockwistDist) {
                pairIndex = (pairIndex + 1) % N;
                clockwistDist += arr[pairIndex];
            }
            maxDist = Math.max(maxDist, totalDist - clockwistDist);
            clockwistDist -= arr[i];
        }

        System.out.println(maxDist);

        bf.close();
        System.exit(0);
    }
}