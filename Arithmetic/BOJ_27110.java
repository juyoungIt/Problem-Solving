// BOJ - 27110
// Problem Sheet - https://www.acmicpc.net/problem/27110

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int totalCount = 0;
        for(int i=0 ; i<3 ; i++) {
            int count = Integer.parseInt(st.nextToken());
            totalCount += Math.min(count, N);
        }

        System.out.println(totalCount);

        bf.close();
        System.exit(0);
    }
}