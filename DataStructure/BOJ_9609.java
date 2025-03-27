// BOJ - 9609
// Problem Sheet - https://www.acmicpc.net/problem/9609

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static String[] missions;
    private static Map<String, Integer> map;
    private static final String OUTPUT_FORMAT = "Case %d: %d";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        missions = new String[n];
        for (int i=0 ; i<n ; i++) {
            missions[i] = br.readLine();
        }
        init();
        br.close();
    }

    private static void init() {
        map = new HashMap<>();
        map.put("HP", 103); map.put("PH", 103);
        map.put("HS", 329); map.put("SH", 329);
        map.put("HK", 466); map.put("KH", 466);
        map.put("HT", 148); map.put("TH", 148);
        map.put("PS", 408); map.put("SP", 408);
        map.put("PK", 577); map.put("KP", 577);
        map.put("PT", 260); map.put("TP", 260);
        map.put("SK", 287); map.put("KS", 287);
        map.put("ST", 226); map.put("TS", 226);
        map.put("KT", 312); map.put("TK", 312);
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<n ; i++) {
            int totalDist = 0;
            missions[i] = "H" + missions[i] + "H";
            for (int j=0 ; j<missions[i].length()-1 ; j++) {
                totalDist += map.get(missions[i].substring(j, j + 2));
            }
            sb.append(String.format(OUTPUT_FORMAT, i + 1, totalDist)).append("\n");
        }
        return sb.toString();
    }

}