// BOJ - 13136
// Problem Sheet - https://www.acmicpc.net/problem/13136

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long r = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(st.nextToken());

        long rCnt = r / n + ((r % n > 0) ? 1 : 0);
        long cCnt = c / n + ((c % n > 0) ? 1 : 0);

        System.out.println(rCnt * cCnt);

        bf.close();
        System.exit(0);
    }
}