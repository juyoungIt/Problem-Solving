// BOJ - 14465
// Problem Sheet - https://www.acmicpc.net/problem/14465

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isBroken = new boolean[n];
        for (int i=0 ; i<b ; i++) {
            int brokenIndex = Integer.parseInt(br.readLine()) - 1;
            isBroken[brokenIndex] = true;
        }

        int curRepairCount = 0;
        for (int i=0 ; i<k ; i++) {
            if (isBroken[i]) {
                curRepairCount++;
            }
        }

        int minRepairCount = curRepairCount;
        for (int i=1 ; i<=n-k ; i++) {
            if (isBroken[i - 1]) {
                curRepairCount--;
            }
            if (isBroken[i + k - 1]) {
                curRepairCount++;
            }
            if (curRepairCount < minRepairCount) {
                minRepairCount = curRepairCount;
            }
        }

        System.out.println(minRepairCount);

        br.close();
        System.exit(0);
    }
}