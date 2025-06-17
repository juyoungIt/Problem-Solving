// BOJ - 30389
// Problem Sheet - https://www.acmicpc.net/problem/30389

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static String[] s;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new String[n];
        for (int i=0 ; i<n ; i++) {
            s[i] = br.readLine();
        }
        br.close();
    }

    private static int solve() {
        Set<String> suffixes = new HashSet<>();
        for (String si : s) {
            for (int i=0 ; i<si.length() ; i++) {
                String suffix = si.substring(i);
                if (suffixes.contains(suffix)) suffixes.remove(suffix);
                else suffixes.add(suffix);
            }
        }
        return suffixes.size();
    }

}