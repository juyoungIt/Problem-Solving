// BOJ - 2371
// Problem Sheet - https://www.acmicpc.net/problem/2371

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static List<Integer>[] files;
    private static int maxLen = 0;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        files = new ArrayList[n];
        for (int i=0 ; i<n ; i++) {
            files[i] = new ArrayList<>();
            String[] row = br.readLine().split(" ");
            maxLen = Math.max(maxLen, row.length - 1);
            for (int j=0 ; j<row.length-1 ; j++) {
                files[i].add(Integer.parseInt(row[j]));
            }
        }
        br.close();
    }

    private static int solve() {
        int start = 0, end = maxLen;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            int fileCount = getFileCount(mid);
            if (fileCount == n) end = mid - 1;
            else start = mid + 1;
        }
        return mid;
    }

    private static int getFileCount(int k) {
        Set<String> fileSet = new HashSet<>();
        for (int i=0 ; i<n ; i++) {
            StringJoiner sj = new StringJoiner(" ");
            for (int j=0 ; j<k ; j++) {
                if (files[i].size() >= k) sj.add(Integer.toString(files[i].get(j)));
                else sj.add("0");
            }
            fileSet.add(sj.toString());
        }
        return fileSet.size();
    }

}