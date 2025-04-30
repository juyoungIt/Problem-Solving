// BOJ - 9357
// Problem Sheet - https://www.acmicpc.net/problem/9357

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT = "Case #%d:";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=t ; i++) {
            Map<String, Set<Integer>> countMap = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j=0 ; j<n ; j++) {
                StringJoiner sj = new StringJoiner(" ");
                String[] row = br.readLine().split(" ");
                for (int k=0 ; k<row.length-1 ; k++) {
                    sj.add(row[k]);
                }
                String name = sj.toString();
                int year = Integer.parseInt(row[row.length - 1]);
                if (!countMap.containsKey(name)) {
                    countMap.put(name, new HashSet<>());
                }
                countMap.get(name).add(year);
            }
            sb.append(String.format(OUTPUT_FORMAT, i)).append("\n");
            countMap.entrySet().stream()
                    .filter(e -> e.getValue().size() < 5)
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(e -> sb.append(e.getKey()).append("\n"));
        }

        System.out.println(sb);
        br.close();
    }
}