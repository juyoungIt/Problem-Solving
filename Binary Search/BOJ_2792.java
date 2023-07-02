// BOJ - 2792
// Problem Sheet - https://www.acmicpc.net/problem/2792

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] jewels = new int[M];
        int minCount = 1;
        int maxCount = 0;
        for(int i=0 ; i<M ; i++) {
            jewels[i] = Integer.parseInt(bf.readLine());
            if(maxCount < jewels[i]) {
                maxCount = jewels[i];
            }
        }

        int middleCount;
        int optimalJewelCount = -1;
        int distributedCount;
        while(minCount <= maxCount) {
            middleCount = (minCount + maxCount) / 2;
            distributedCount = getDistributedCount(jewels, middleCount);
            if(distributedCount > N) {
                minCount = middleCount + 1;
            } else {
                optimalJewelCount = middleCount;
                maxCount = middleCount - 1;
            }
        }

        System.out.println(optimalJewelCount);

        bf.close();
        System.exit(0);
    }

    private static int getDistributedCount(int[] jewels, int unitCount) {
        int distributedCount = 0;
        for(int jewel : jewels) {
            distributedCount += jewel / unitCount;
            if(jewel % unitCount > 0) {
                distributedCount++;
            }
        }
        return distributedCount;
    }
}