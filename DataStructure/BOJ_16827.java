// BOJ - 16827
// Problem Sheet - https://www.acmicpc.net/problem/16827

import java.util.*;
import java.io.*;

public class Main {

    static class Liquid implements Comparable<Liquid> {
        private final String color;
        private final int density;

        public Liquid(String color, int density) {
            this.color = color;
            this.density = density;
        }

        public String getColor() { return this.color; }
        public int getDensity() { return this.density; }

        @Override
        public int compareTo(Liquid l) {
            return Integer.compare(this.density, l.getDensity());
        }
    }

    private static int n, m;
    private static Liquid[] liquids;
    private static String[] layers;
    private static final String YES = "Yes", NO = "No";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        liquids = new Liquid[n];
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            String color = row[0];
            int density = Integer.parseInt(row[1]);
            liquids[i] = new Liquid(color, density);
        }
        m = Integer.parseInt(br.readLine());
        layers = new String[m];
        for (int i=0 ; i<m ; i++) {
            layers[i] = br.readLine();
        }
        br.close();
    }

    private static String solve() {
        Map<String, TreeSet<Integer>> liquidMap = new HashMap<>();
        for (Liquid liquid : liquids) {
            if (!liquidMap.containsKey(liquid.getColor())) {
                liquidMap.put(liquid.getColor(), new TreeSet<>());
            }
            liquidMap.get(liquid.getColor()).add(liquid.getDensity());
        }
        int prevDensity = 0;
        boolean isValid = true;
        for (String color : layers) {
            if (!liquidMap.containsKey(color) || liquidMap.get(color).isEmpty()) {
                isValid = false;
                break;
            }
            Integer candidate = liquidMap.get(color).higher(prevDensity);
            if (candidate == null) {
                isValid = false;
                break;
            }
            prevDensity = candidate;
        }
        return isValid ? YES : NO;
    }

}