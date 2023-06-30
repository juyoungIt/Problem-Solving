// BOJ - 6236
// Problem Sheet - https://www.acmicpc.net/problem/6236

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

        long min = 1;
        long max = Integer.MAX_VALUE;
        long middle;
        long minUnitPrice = Integer.MAX_VALUE;
        while(min < max) {
            middle = (min + max) >> 1;
            long withdrawalCount = getWithdrawalCount(sequence, middle);
            if(withdrawalCount > M || withdrawalCount <= 0) {
                min = middle + 1;
            } else {
                minUnitPrice = Math.min(minUnitPrice, middle);
                max = middle;
            }
        }

        System.out.println(minUnitPrice);

        bf.close();
        System.exit(0);
    }

    private static long getWithdrawalCount(int[] sequence, long unit) {
        long withdrawalCount = 0;
        long curValue = 0;
        for(int price : sequence) {
            if(price > unit) {
                return -1;
            }
            if(curValue < price) {
                withdrawalCount++;
                curValue = unit;
            }
            curValue -= price;
        }
        return withdrawalCount;
    }
}