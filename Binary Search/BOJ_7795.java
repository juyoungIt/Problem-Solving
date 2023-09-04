// BOJ - 7795
// Problem Sheet - https://www.acmicpc.net/problem/7795

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[] arrA, arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            int totalValidPairCount = 0;
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arrA = new int[N];
            arrB = new int[M];
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<N ; j++) {
                arrA[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<M ; j++) {
                arrB[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrB);
            for(int element : arrA) {
                totalValidPairCount += findLowerbound(element);
            }
            sb.append(totalValidPairCount).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
    
    private static int findLowerbound(int target) {
        int left = 0;
        int right = M;
        while(left < right) {
            int mid = (left + right) / 2;
            if(arrB[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}