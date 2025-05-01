// BOJ - 18009
// Problem Sheet - https://www.acmicpc.net/problem/18009

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static final String OUTPUT_FORMAT = "Data Set %d:\n%d %d\n\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=k ; i++) {
            String[] row = br.readLine().split(" ");
            Map<String, Integer> propertyMap = new HashMap<>();
            int n = Integer.parseInt(row[0]);
            int m = Integer.parseInt(row[1]);
            for (int j=0 ; j<n ; j++) {
                row = br.readLine().split(" ");
                propertyMap.put(row[0], Integer.parseInt(row[1]));
            }
            row = br.readLine().split(" ");
            int min = 0, max = 0;
            int unknownCount = 0;
            for (int j=0 ; j<m ; j++) {
                if (!row[j].equals("?")) {
                    min += propertyMap.get(row[j]);
                    max += propertyMap.get(row[j]);
                    propertyMap.remove(row[j]);
                    continue;
                }
                unknownCount++;
            }
            List<Integer> remain = propertyMap.values().stream().sorted().collect(Collectors.toList());
            for (int j=0 ; j<unknownCount ; j++) {
                min += remain.get(j);
                max += remain.get(remain.size() - 1 - j);
            }
            sb.append(String.format(OUTPUT_FORMAT, i, min, max));
        }
        System.out.println(sb);
        br.close();
    }
}