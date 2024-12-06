// BOJ - 15017
// Problem Sheet - https://www.acmicpc.net/problem/15017

import java.util.*;
import java.io.*;

public class Main {

    static class Runner implements Comparable<Runner> {
        private final String name;
        private final double first;
        private final double second;

        public Runner(String name, double first, double second) {
            this.name = name;
            this.first = first;
            this.second = second;
        }

        public String getName() { return this.name; }
        public double getFirst() { return this.first; }
        public double getSecond() { return this.second; }

        @Override
        public int compareTo(Runner r) {
            return Double.compare(this.second, r.getSecond());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Runner> runners = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            double first = Double.parseDouble(input[1]);
            double seconds = Double.parseDouble(input[2]);
            runners.add(new Runner(name, first, seconds));
        }
        Collections.sort(runners);

        double minRecords = 10_000;
        for (int i=0 ; i<n ; i++) {
            int runnerCount = 1;
            List<String> names = new ArrayList<>(4);
            double totalSum = runners.get(i).getFirst();
            names.add(runners.get(i).getName());
            for (int j=0 ; j<n ; j++) {
                if (i == j) continue;
                if (runnerCount == 4) break;
                totalSum += runners.get(j).getSecond();
                names.add(runners.get(j).getName());
                runnerCount++;
            }
            if (minRecords > totalSum) {
                sb.setLength(0);
                minRecords = totalSum;
                sb.append(totalSum).append("\n");
                names.forEach(name -> sb.append(name).append("\n"));
            }
        }

        System.out.println(sb);
        br.close();
    }
}