// BOJ - 13702
// Problem Sheet - https://www.acmicpc.net/problem/13702

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] capacities = new long[n];
        for(int i=0 ; i<n ; i++) {
            capacities[i] = Long.parseLong(bf.readLine());
        }

        long min = 0;
        long max = Integer.MAX_VALUE;
        long maxAmount = 0;
        while(min <= max) {
            long mid = (min + max) / 2;
            long servedCount = getServedCounts(capacities, mid);
            if(servedCount >= k) {
                maxAmount = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(maxAmount);

        bf.close();
        System.exit(0);
    }

    private static long getServedCounts(long[] capacities, long amount) {
        long servedCount = 0;
        if(amount == 0) {
            return -1;
        }
        for(long capacity : capacities) {
            servedCount += capacity / amount;
        }
        return servedCount;
    }
}