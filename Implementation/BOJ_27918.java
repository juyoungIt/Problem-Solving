// BOJ - 27918
// Problem Sheet - https://www.acmicpc.net/problem/27918

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int d = 0, p = 0;
        while (n-- > 0) {
            char c = br.readLine().charAt(0);
            if (c == 'D') d++;
            else p++;
            if (Math.abs(d - p) >= 2) break;
        }
        System.out.printf("%d:%d\n", d, p);
        br.close();
    }
}
