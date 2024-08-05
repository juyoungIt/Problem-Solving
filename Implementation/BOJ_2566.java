// BOJ - 2566
// Problem Sheet - https://www.acmicpc.net/problem/2566

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int maxValue = -1;
        int maxX = 0, maxY = 0;
        for (int i=1 ; i<=9 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1 ; j<=9 ; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value > maxValue) {
                    maxValue = value;
                    maxX = i;
                    maxY = j;
                }
            }
        }

        System.out.printf("%d\n%d %d", maxValue, maxX, maxY);

        br.close();
        System.exit(0);
    }
}