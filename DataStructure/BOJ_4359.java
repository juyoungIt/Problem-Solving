// BOJ - 4359
// Problem Sheet - https://www.acmicpc.net/problem/4359

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int P = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);
        Map<Integer, boolean[]> hear = new HashMap<>();
        for (int i=1 ; i<=P ; i++) {
            hear.put(i, new boolean[T + 1]);
        }

        while (true) {
            String row = br.readLine();
            if (row == null) break;
            String[] token = row.split(" ");
            int i = Integer.parseInt(token[0]);
            int j = Integer.parseInt(token[1]);
            hear.get(i)[j] = true;
        }

        Set<String> treeGroups = new HashSet<>();
        for (boolean[] trees : hear.values()) {
            treeGroups.add(toString(trees));
        }
        System.out.println(treeGroups.size());
        br.close();
    }

    private static String toString(boolean[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i=1 ; i<arr.length ; i++) {
            sb.append(arr[i] ? 1 : 0);
        }
        return sb.toString();
    }
}
