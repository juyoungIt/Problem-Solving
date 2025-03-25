// BOJ - 7847
// Problem Sheet - https://www.acmicpc.net/problem/7847

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder report = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Map<Integer, Long>> storage = new TreeMap<>();
        Set<Integer> itemSet = new TreeSet<>();
        for (int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int item = Integer.parseInt(st.nextToken());
            int store = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            if (!storage.containsKey(store)) storage.put(store, new HashMap<>());
            storage.get(store).put(item, storage.get(store).getOrDefault(item, 0L) + count);
            itemSet.add(item);
        }

        report.append("-1 ");
        for (int item : itemSet) report.append(item).append(" ");
        report.append("\n");
        for (int store : storage.keySet()) {
            report.append(store).append(" ");
            for (int item : itemSet) {
                report.append(storage.get(store).getOrDefault(item, 0L)).append(" ");
            }
            report.append("\n");
        }

        System.out.println(report);
        br.close();
    }
}