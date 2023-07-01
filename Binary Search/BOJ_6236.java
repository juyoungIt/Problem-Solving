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

        int[] amounts = new int[N];
        int minAmount = 1;
        int maxAmount = 10000 * N;
        for(int i=0 ; i<N ; i++) {
            amounts[i] = Integer.parseInt(bf.readLine());
            if(maxAmount < amounts[i]) {
                maxAmount = amounts[i];
            }
        }

        int curAmounts;
        int optimalAmounts = -1;
        int withdrawalCount;
        while(minAmount <= maxAmount) {
            curAmounts = (minAmount + maxAmount) / 2;
            withdrawalCount = getWithdrawalCount(amounts, curAmounts);
            if(withdrawalCount <= 0 || withdrawalCount > M) {
                minAmount = curAmounts + 1;
            } else {
                optimalAmounts = curAmounts;
                maxAmount = curAmounts - 1;
            }
        }

        System.out.println(optimalAmounts);

        bf.close();
        System.exit(0);
    }

    private static int getWithdrawalCount(int[] amounts, int unitAmount) {
        int withdrawalCount = 1;
        int curAmount = unitAmount;
        for(int amount : amounts) {
            if(amount > unitAmount) {
                return -1;
            }
            if(curAmount < amount) {
                withdrawalCount++;
                curAmount = unitAmount;
            }
            curAmount -= amount;
        }
        return withdrawalCount;
    }
}