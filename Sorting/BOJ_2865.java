// BOJ - 2865
// Problem Sheet - https://www.acmicpc.net/problem/2865

import java.util.*;
import java.io.*;

public class Main {

    static class Ability implements Comparable<Ability> {
        private final int index;
        private final int genre;
        private final double value;

        public Ability(int index, int genre, double value) {
            this.index = index;
            this.genre = genre;
            this.value = value;
        }

        public int getIndex() { return this.index; }
        public int getGenre() { return this.genre; }
        public double getValue() { return this.value; }

        @Override
        public int compareTo(Ability a) {
            return Double.compare(a.getValue(), this.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Ability> abilities = new PriorityQueue<>();
        for (int i=1 ; i<=M ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1 ; j<=N ; j++) {
                int index = Integer.parseInt(st.nextToken());
                double value = Double.parseDouble(st.nextToken());
                abilities.add(new Ability(index, i, value));
            }
        }

        double totalValue = 0.0;
        Set<Integer> finalist = new HashSet<>();
        while (finalist.size() < K) {
            Ability ability = abilities.poll();
            if (finalist.contains(ability.getIndex())) {
                continue;
            }
            finalist.add(ability.getIndex());
            totalValue += ability.getValue();
        }

        System.out.printf("%.1f\n", Math.round(totalValue * 10) / 10.0);

        br.close();
    }
}