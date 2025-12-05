// BOJ - 14730
// Problem Sheet - https://www.acmicpc.net/problem/14730

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            answer += c * k;
        }
        System.out.println(answer);
        br.close();
    }
}
