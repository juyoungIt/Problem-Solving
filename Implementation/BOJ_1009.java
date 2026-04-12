// BOJ - 1009
// Problem Sheet - https://www.acmicpc.net/problem/1009

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = a;
            for (int i=1 ; i<b ; i++) {
                value = (value * a) % 10;
            }
            value %= 10;
            System.out.println(value == 0 ? 10 : value);
        }
        br.close();
    }
}