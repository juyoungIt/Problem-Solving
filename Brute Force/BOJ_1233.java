// BOJ - 1233
// Problem Sheet - https://www.acmicpc.net/problem/1233

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());
        int totalSum = S1 + S2 + S3;
        int[] sumCounts = new int[totalSum + 1];
        for(int i=1 ; i<=S1 ; i++) {
            for(int j=1 ; j<=S2 ; j++) {
                for(int k=1 ; k<=S3 ; k++) {
                    sumCounts[i + j + k]++;
                }
            }
        }

        int maxSum = 0;
        int maxCount = 0;
        for(int i=0 ; i<=totalSum ; i++) {
            if(sumCounts[i] > maxCount) {
                maxSum = i;
                maxCount = sumCounts[i];
            }
        }

        System.out.println(maxSum);

        bf.close();
        System.exit(0);
    }
}