// BOJ - 29790
// Problem Sheet - https://www.acmicpc.net/problem/29790

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        if (n >= 1_000 && (u >= 8_000 || l >= 260)) {
            System.out.println("Very Good");
        } else if (n >= 1_000) {
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }
        br.close();
    }
}
