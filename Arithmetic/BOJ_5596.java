// BOJ - 5596
// Problem Sheet - https://www.acmicpc.net/problem/5596

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int totalA = 0;
        int totalB = 0;

        for(int i=0 ; i<4 ; i++) {
            totalA += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<4 ; i++) {
            totalB += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(totalA, totalB));

        bf.close();
        System.exit(0);
    }
}