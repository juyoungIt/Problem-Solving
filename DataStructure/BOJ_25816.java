// BOJ - 25816
// Problem Sheet - https://www.acmicpc.net/problem/25816

import java.util.*;
import java.io.*;

public class Main {

    static class Univsity implements Comparable<Univsity> {
        private final String name;
        private final double performance;

        public Univsity(String name, double performance) {
            this.name = name;
            this.performance = performance;
        }

        public String getName() { return this.name; }
        public double getPerformance() { return this.performance; }

        @Override
        public int compareTo(Univsity u) {
            return Double.compare(this.performance, u.getPerformance());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> rankSumMapper = new HashMap<>();
        Map<String, Integer> teamCountMapper = new HashMap<>();
        for (int i=1 ; i<=n ; i++) {
            String univName = br.readLine();
            rankSumMapper.put(univName, rankSumMapper.getOrDefault(univName, 0) + i);
            teamCountMapper.put(univName, teamCountMapper.getOrDefault(univName, 0) + 1);
        }

        List<Univsity> univsities = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : rankSumMapper.entrySet()) {
            univsities.add(new Univsity(entry.getKey(), (double) entry.getValue() / teamCountMapper.get(entry.getKey())));
        }
        Collections.sort(univsities);

        for (Univsity univsity : univsities) {
            sb.append(univsity.getName()).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}