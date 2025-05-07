// BOJ - 12186
// Problem Sheet - https://www.acmicpc.net/problem/12186

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=t ; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, String> routeMap = new HashMap<>();
            Map<String, Integer> countMap = new HashMap<>();
            for (int j=0 ; j<n ; j++) {
                String dept = br.readLine();
                String dest = br.readLine();
                routeMap.put(dept, dest);
                countMap.put(dept, countMap.getOrDefault(dept, 0) + 1);
                countMap.put(dest, countMap.getOrDefault(dest, 0) + 1);
            }
            String dept = countMap.entrySet().stream()
                    .filter(e -> e.getValue() == 1 && routeMap.containsKey(e.getKey()))
                    .collect(Collectors.toList())
                    .get(0)
                    .getKey();
            StringJoiner sj = new StringJoiner(" ");
            String prev = dept;
            while (routeMap.containsKey(prev)) {
                sj.add(String.format("%s-%s", prev, routeMap.get(prev)));
                prev = routeMap.get(prev);
            }
            sb.append(String.format(OUTPUT_FORMAT, i, sj)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}