// BOJ - 21591
// Problem Sheet - https://www.acmicpc.net/problem/21591

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wc = Integer.parseInt(st.nextToken());
        int hc = Integer.parseInt(st.nextToken());
        int ws = Integer.parseInt(st.nextToken());
        int hs = Integer.parseInt(st.nextToken());

        if (wc - ws >= 2 && hc - hs >= 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        br.close();
        System.exit(0);
    }
}