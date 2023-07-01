// BOJ - 2512
// Problem Sheet - https://www.acmicpc.net/problem/2512

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] provinces = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int maxRequest = 0;
        int totalRequest = 0;
        for(int i=0 ; i<N ; i++) {
            provinces[i] = Integer.parseInt(st.nextToken());
            if(maxRequest < provinces[i]) {
                maxRequest = provinces[i];
            }
            totalRequest += provinces[i];
        }
        int M = Integer.parseInt(bf.readLine());

        if(totalRequest <= M) {
            System.out.println(maxRequest);
        } else {
            int minUpperBound = 1;
            int maxUpperBound = 100000;
            int curUpperBound;
            int curTotalRequest;
            int optimalUpperBound = -1;
            while(minUpperBound <= maxUpperBound) {
                curUpperBound = (minUpperBound + maxUpperBound) / 2;
                curTotalRequest = getTotalRequest(provinces, curUpperBound);
                if(curTotalRequest <= M) {
                    optimalUpperBound = curUpperBound;
                    minUpperBound = curUpperBound + 1;
                } else {
                    maxUpperBound = curUpperBound - 1;
                }
            }
            System.out.println(optimalUpperBound);
        }

        bf.close();
        System.exit(0);
    }

    private static int getTotalRequest(int[] requests, int upperBound) {
        int totalRequest = 0;
        for(int request : requests) {
            totalRequest += Math.min(request, upperBound);
        }
        return totalRequest;
    }
}