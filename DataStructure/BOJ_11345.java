// BOJ - 11345
// Problem Sheet - https://www.acmicpc.net/problem/11345

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_A = "what a lovely party";
    private static final String OUTPUT_B = "you've messed up, Cornell";

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine(); // read empty line
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> countMapA = new HashMap<>();
            Map<Integer, Integer> countMapB = new HashMap<>();
            String[] row = br.readLine().split(" ");
            for (int i=0 ; i<n ; i++) {
                int id = Integer.parseInt(row[i]);
                countMapA.put(id, countMapA.getOrDefault(id, 0) + 1);
            }
            row = br.readLine().split(" ");
            for (int i=0 ; i<n ; i++) {
                int id = Integer.parseInt(row[i]);
                countMapB.put(id, countMapB.getOrDefault(id, 0) + 1);
            }
            int[] countA = countMapA.values().stream()
                    .mapToInt(Integer::intValue)
                    .sorted()
                    .toArray();
            int[] countB = countMapB.values().stream()
                    .mapToInt(Integer::intValue)
                    .sorted()
                    .toArray();
            sb.append(isSameArray(countA, countB) ? OUTPUT_A : OUTPUT_B).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isSameArray(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i=0 ; i<a.length ; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}