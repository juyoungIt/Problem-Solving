// BOJ - 10025
// Problem Sheet - https://www.acmicpc.net/problem/10025

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] cage = new int[1000001];
        int totalIceAmount = 0;
        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(bf.readLine());
            int iceAmount = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            cage[location] = iceAmount;
            if(location <= 2 * K) {
                totalIceAmount += iceAmount;
            }
        }

        int leftIndex = 0;
        int rightIndex = 2 * K;
        int maxIceAmount = totalIceAmount;
        while(rightIndex < 1000000) {
            totalIceAmount -= cage[leftIndex++];
            totalIceAmount += cage[++rightIndex];
            maxIceAmount = Math.max(maxIceAmount, totalIceAmount);
        }

        System.out.println(maxIceAmount);

        bf.close();
        System.exit(0);
    }
}