// BOJ - 1296
// Problem Sheet - https://www.acmicpc.net/problem/1296

import java.util.*;
import java.io.*;

public class Main {

    static class Team implements Comparable<Team> {
        private final String name;
        private final int possibility;

        public Team(String name, int possibility) {
            this.name = name;
            this.possibility = possibility;
        }

        public String getName() { return this.name; }
        public int getPossibility() { return this.possibility; }

        @Override
        public int compareTo(Team t) {
            if (this.possibility == t.getPossibility()) {
                return this.name.compareTo(t.getName());
            }
            return t.getPossibility() - this.possibility;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Team[] teams = new Team[n];
        for (int i=0 ; i<n ; i++) {
            int[] counts = new int[4];
            updateCountInfo(counts, name);
            String candidate = br.readLine();
            updateCountInfo(counts, candidate);
            int possibility = getPossibility(counts);
            teams[i] = new Team(candidate, possibility);
        }
        Arrays.sort(teams);

        System.out.println(teams[0].getName());

        br.close();
        System.exit(0);
    }

    private static int getPossibility(int[] countInfo) {
        int sum = 1;
        for (int i=0 ; i<countInfo.length-1 ; i++) {
            for (int j=i+1 ; j<countInfo.length ; j++) {
                sum *= (countInfo[i] + countInfo[j]);
            }
        }
        return sum % 100;
    }

    private static void updateCountInfo(int[] countInfo, String name) {
        for (int j=0 ; j<name.length() ; j++) {
            int index = getIndex(name.charAt(j));
            if (index >= 0) {
                countInfo[index]++;
            }
        }
    }

    private static int getIndex(char c) {
        if (c == 'L') return 0;
        else if (c == 'O') return 1;
        else if (c == 'V') return 2;
        else if (c == 'E') return 3;
        else return -1;
    }
}