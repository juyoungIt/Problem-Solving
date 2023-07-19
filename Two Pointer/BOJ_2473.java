// BOJ - 2473
// Problem Sheet - https://www.acmicpc.net/problem/2473

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<N ; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solutions);

        long optimalMixResult = 3_000_000_000L;
        int[] result = new int[3];
        for(int i=0 ; i<N ; i++) {
            int left = i+1;
            int right = N-1;
            while(left < right) {
                long mixResult = (long)solutions[i] + solutions[left] + solutions[right];
                if(Math.abs(mixResult) < optimalMixResult) {
                    optimalMixResult = Math.abs(mixResult);
                    result[0] = solutions[i];
                    result[1] = solutions[left];
                    result[2] = solutions[right];
                }
                if(mixResult < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.printf("%d %d %d\n", result[0], result[1], result[2]);

        bf.close();
        System.exit(0);
    }
}