// BOJ - 24653
// Problem Sheet - https://www.acmicpc.net/problem/24653

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] postDays = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            postDays[i] = Integer.parseInt(row[i]);
        }
        int t = Integer.parseInt(br.readLine());
        Set<Integer> groups = new HashSet<>();
        for (int postDay : postDays) {
            groups.add(postDay / t);
        }
        System.out.println(groups.size());
        br.close();
    }
}