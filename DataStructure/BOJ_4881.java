// BOJ - 4881
// Problem Sheet - https://www.acmicpc.net/problem/4881

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String outputFormat = "%d %d %d";

        while (true) {
            String[] row = br.readLine().split(" ");
            int a = Integer.parseInt(row[0]);
            int b = Integer.parseInt(row[1]);
            if (a == 0 && b == 0) break;
            sb.append(String.format(outputFormat, a, b, getMinCommonSeqLen(a, b))).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int getMinCommonSeqLen(int a, int b) {
        Map<Integer, Integer> seqMapA = buildSeqMap(a);
        Map<Integer, Integer> seqMapB = buildSeqMap(b);
        int minCommonSeqLen = Integer.MAX_VALUE;
        for (int element : seqMapA.keySet()) {
            if (!seqMapB.containsKey(element)) continue;
            minCommonSeqLen = Math.min(minCommonSeqLen, seqMapA.get(element) + seqMapB.get(element));
        }
        return minCommonSeqLen == Integer.MAX_VALUE ? 0 : minCommonSeqLen;
    }

    private static Map<Integer, Integer> buildSeqMap(int n) {
        Map<Integer, Integer> seqMap = new HashMap<>();
        int seq = 1;
        seqMap.put(n, seq++);
        int next = n;
        while (true) {
            next = getSquareSum(next);
            if (seqMap.containsKey(next)) break;
            seqMap.put(next, seq++);
        }
        return seqMap;
    }

    private static int getSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

}