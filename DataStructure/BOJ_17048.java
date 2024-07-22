// BOJ - 17048
// Problem Sheet - https://www.acmicpc.net/problem/17048

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] initFreq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] requiredFreq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> freqDiffsCount = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            int diff = initFreq[i] - requiredFreq[i];
            freqDiffsCount.put(diff, freqDiffsCount.getOrDefault(diff, 0) + 1);
        }

        int maxControlableDronCount = 0;
        for (int count : freqDiffsCount.values()) {
            if (count > maxControlableDronCount) {
                maxControlableDronCount = count;
            }
        }
        System.out.println(maxControlableDronCount);

        br.close();
        System.exit(0);
    }
}