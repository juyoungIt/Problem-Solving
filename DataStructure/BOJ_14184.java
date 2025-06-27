// BOJ - 14184
// Problem Sheet - https://www.acmicpc.net/problem/14184

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Logo implements Comparable<Logo> {
        private final int id;
        private int first;
        private int second;
        private int third;
        private int score;

        public Logo(int id) {
            this.id = id;
        }

        public int getId() { return this.id; }
        public int getFirst() { return this.first; }
        public int getSecond() { return this.second; }
        public int getThird() { return this.third; }
        public int getScore() { return this.score; }

        public void addFirst() {
            this.first++;
            this.score += 3;
        }
        public void addSecond() {
            this.second++;
            this.score += 2;
        }
        public void addThird() {
            this.third++;
            this.score += 1;
        }

        @Override
        public int compareTo(Logo l) {
            if (this.score == l.getScore()) {
                if (this.first == l.getFirst()) {
                    if (this.second == l.getSecond()) {
                        return this.id - l.getId();
                    }
                    return l.getSecond() - this.second;
                }
                return l.getFirst() - this.first;
            }
            return l.getScore() - this.score;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Map<Integer, Logo> logoMap = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            for (int i=0 ; i<n ; i++) {
                String[] row = br.readLine().split(" ");
                int d = Integer.parseInt(row[0]);
                for (int j=1 ; j<=d ; j++) {
                    int logo = Integer.parseInt(row[j]);
                    if (!logoMap.containsKey(logo)) logoMap.put(logo, new Logo(logo));
                    if (j == 1) logoMap.get(logo).addFirst();
                    if (j == 2) logoMap.get(logo).addSecond();
                    if (j == 3) logoMap.get(logo).addThird();
                }
            }
            List<Logo> logos = logoMap.values().stream().sorted().collect(Collectors.toList());
            Logo prev = logos.get(0);
            for (Logo logo : logos) {
                if (!isSameRank(prev, logo)) break;
                sb.append(logo.getId()).append(" ");
                prev = logo;
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isSameRank(Logo l1, Logo l2) {
        return l1.getScore() == l2.getScore() && l1.getFirst() == l2.getFirst() && l1.getSecond() == l2.getSecond();
    }
}