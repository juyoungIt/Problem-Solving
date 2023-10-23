// BOJ - 2559
// Problem Sheet - https://www.acmicpc.net/problem/2559

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] temperatures = new int[n];
        st = new StringTokenizer(bf.readLine());

        int curSum = 0;
        for(int i=0 ; i<n ; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
            if(i < k) {
                curSum += temperatures[i];
            }
        }

        int left = 0, right = k-1;
        int maxSum = -100_000_000;
        while(true) {
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if(right >= n-1) {
                break;
            }
            curSum -= temperatures[left++];
            curSum += temperatures[++right];
        }

        System.out.println(maxSum);

        bf.close();
        System.exit(0);
    }
}