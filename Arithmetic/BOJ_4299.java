// BOJ - 4299
// Problem Sheet - https://www.acmicpc.net/problem/4299

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());
        int teamA = (sum + diff) / 2;
        int teamB = (sum - diff) / 2;

        if(sum >= diff && (sum + diff) % 2 == 0 && (sum - diff) % 2 == 0) {
            System.out.println(Math.max(teamA, teamB) + " " + Math.min(teamA, teamB));
        } else {
            System.out.println(-1);
        }

        bf.close();
        System.exit(0);
    }
}