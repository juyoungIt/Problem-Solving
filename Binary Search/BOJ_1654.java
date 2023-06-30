// BOJ - 1654
// Problem Sheet - https://www.acmicpc.net/problem/1654

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] cables = new long[K];
        for(int i=0 ; i<K ; i++) {
            cables[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(cables);

        long start = 1;
        long end = cables[K-1] + 1;
        long middle;
        long maxLength = 0;
        while(start < end) {
            middle = (start + end) / 2;
            long counts = 0;
            for(long cable : cables) {
                counts += cable / middle;
            }
            if(counts < N) {
                end = middle;
            } else {
                maxLength = middle;
                start = middle + 1;
            }
        }

        System.out.println(maxLength);

        bf.close();
        System.exit(0);
    }
}