// BOJ - 8933
// Problem Sheet - https://www.acmicpc.net/problem/8933

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] row = br.readLine().split(" ");
            int k = Integer.parseInt(row[0]);
            String dna = row[1];
            sb.append(getKMCSCount(dna, k)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int getKMCSCount(String dna, int k) {
        Map<Integer, Integer> mcsMap = new HashMap<>();
        int[] counts = new int[4];
        for (int i=0 ; i<k ; i++) {
            char c = dna.charAt(i);
            counts[getCountIndex(c)]++;
        }
        mcsMap.put(getCountKey(counts), 1);
        for (int i=1 ; i<=dna.length()-k ; i++) {
            counts[getCountIndex(dna.charAt(i - 1))]--;
            counts[getCountIndex(dna.charAt(i + k - 1))]++;
            int countKey = getCountKey(counts);
            mcsMap.put(countKey, mcsMap.getOrDefault(countKey, 0) + 1);
        }
        int kMCS = 0;
        for (int count : mcsMap.values()) {
            kMCS = Math.max(kMCS, count);
        }
        return kMCS;
    }

    private static int getCountIndex(char c) {
        if (c == 'A') return 0;
        else if (c == 'C') return 1;
        else if (c == 'G') return 2;
        else return 3;
    }

    private static int getCountKey(int[] counts) {
        return counts[0] + counts[1] * 600 + counts[2] * 600 * 600 + counts[3] * 600 * 600 * 600;
    }

}
