// BOJ - 21890
// Problem Sheet - https://www.acmicpc.net/problem/21890

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n-- > 0) {
            String[] tokens = br.readLine().split("\\.");
            if (!isValidName(tokens)) continue;
            cnt++;
        }
        System.out.println(cnt);
        br.close();
    }

    private static boolean isValidName(String[] tokens) {
        return tokens.length == 2
                && !tokens[0].isEmpty()
                && tokens[0].length() <= 8
                && !tokens[1].isEmpty()
                && tokens[1].length() <= 3;
    }
}