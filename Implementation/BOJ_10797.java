// BOJ - 10797
// Problem Sheet - https://www.acmicpc.net/problem/10797

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int c = 0;
        for (int i=0 ; i<5 ; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a % 10 == n % 10) c++;
        }
        System.out.println(c);
    }
}
