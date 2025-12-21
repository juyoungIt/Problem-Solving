// BOJ - 30999
// Problem Sheet - https://www.acmicpc.net/problem/30999

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        int majority = m / 2 + m % 2;
        for (int i=0 ; i<n ; i++) {
            String judgement = br.readLine();
            int agree = 0;
            for (int j=0 ; j<m ; j++) {
                if (judgement.charAt(j) == 'O') {
                    agree++;
                }
            }
            if (agree >= majority) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}
