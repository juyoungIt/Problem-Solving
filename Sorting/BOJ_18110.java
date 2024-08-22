// BOJ - 18110
// Problem Sheet - https://www.acmicpc.net/problem/18110

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] levels = new int[n];
        for (int i=0 ; i<n ; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(levels);

        int excludeCount = getExcludeCount(n);
        int levelSum = 0;
        int contributorCount = 0;
        for (int i=excludeCount ; i<n-excludeCount ; i++) {
            levelSum += levels[i];
            contributorCount++;
        }

        System.out.println((int) Math.round((double) levelSum / contributorCount));

        br.close();
        System.exit(0);
    }

    private static int getExcludeCount(int n) {
        return (int) Math.round((double) n * 0.15);
    }
}