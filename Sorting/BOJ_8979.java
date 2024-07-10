// BOJ - 8979
// Problem Sheet - https://www.acmicpc.net/problem/8979

import java.util.*;
import java.io.*;

public class Main {

    static class Country implements Comparable<Country> {
        private final int index;
        private final int gold;
        private final int silver;
        private final int bronze;

        public Country(int index, int gold, int silver, int bronze) {
            this.index = index;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int getIndex() { return this.index; }
        public int getGold() { return this.gold; }
        public int getSilver() { return this.silver; }
        public int getBronze() { return this.bronze; }

        @Override
        public int compareTo(Country o) {
            if (this.gold == o.getGold()) {
                if (this.silver == o.getSilver()) {
                    return Integer.compare(this.bronze, o.getBronze()) * -1;
                }
                return Integer.compare(this.silver, o.getSilver()) * -1;
            }
            return Integer.compare(this.gold, o.getGold()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Country[] countries = new Country[n];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries[i] = new Country(index, gold, silver, bronze);
        }
        Arrays.sort(countries);

        Map<Integer, Integer> rankMapper = getRankMapper(n, countries);
        System.out.println(rankMapper.get(k));

        br.close();
        System.exit(0);
    }

    private static Map<Integer, Integer> getRankMapper(int n, Country[] countries) {
        Map<Integer, Integer> rankMapper = new HashMap<>();
        int rank = 1;
        int sameRankCount = 1;
        rankMapper.put(countries[0].getIndex(), rank);
        for (int i=1; i<n; i++) {
            if (countries[i-1].getGold() == countries[i].getGold()
                    && countries[i-1].getSilver() == countries[i].getSilver()
                    && countries[i-1].getBronze() == countries[i].getBronze()) {
                sameRankCount++;
                rankMapper.put(countries[i].getIndex(), rank);
            } else {
                rank += sameRankCount;
                rankMapper.put(countries[i].getIndex(), rank);
                sameRankCount = 1;
            }
        }
        return rankMapper;
    }
}