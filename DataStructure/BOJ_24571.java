// BOJ - 24571
// Problem Sheet - https://www.acmicpc.net/problem/24571

import java.util.*;
import java.io.*;

public class Main {

    private static int x, y, g;
    private static String[][] sameGroup, diffGroup;
    private static Map<String, Integer> groups;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        sameGroup = new String[x][2];
        for (int i=0 ; i<x ; i++) {
            String[] row = br.readLine().split(" ");
            sameGroup[i][0] = row[0];
            sameGroup[i][1] = row[1];
        }
        y = Integer.parseInt(br.readLine());
        diffGroup = new String[y][2];
        for (int i=0 ; i<y ; i++) {
            String[] row = br.readLine().split(" ");
            diffGroup[i][0] = row[0];
            diffGroup[i][1] = row[1];
        }
        groups = new HashMap<>();
        g = Integer.parseInt(br.readLine());
        for (int i=0 ; i<g ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<3 ; j++) {
                groups.put(row[j], i);
            }
        }
        br.close();
    }

    private static int solve() {
        int violationCount = 0;
        for (int i=0 ; i<x ; i++) {
            String a = sameGroup[i][0];
            String b = sameGroup[i][1];
            if (!groups.get(a).equals(groups.get(b))) {
                violationCount++;
            }
        }
        for (int i=0 ; i<y ; i++) {
            String a = diffGroup[i][0];
            String b = diffGroup[i][1];
            if (groups.get(a).equals(groups.get(b))) {
                violationCount++;
            }
        }
        return violationCount;
    }

}