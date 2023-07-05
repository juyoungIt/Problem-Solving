// BOJ - 2118
// Problem Sheet - https://www.acmicpc.net/problem/2118

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N+1];
        int[] acc = new int[N+1];
        for(int i=1 ; i<=N ; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            acc[i] = acc[i-1] + arr[i];
        }

        int maxDist = 0;
        for(int i=1 ; i<N ; i++) {
            for(int j=i+1 ; j<=N ; j++) {
                int clockwiseDist = acc[j-1] - acc[i-1];
                int countClockwiseDist = acc[N] - clockwiseDist;
                int curDist = Math.min(clockwiseDist, countClockwiseDist);
                if(maxDist < curDist) {
                    maxDist = curDist;
                }
            }
        }

        System.out.println(maxDist);

        bf.close();
        System.exit(0);
    }
}