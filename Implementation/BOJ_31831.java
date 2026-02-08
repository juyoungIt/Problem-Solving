// BOJ - 31831
// Problem Sheet - https://www.acmicpc.net/problem/31831

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int count = 0;
        for (int i=0 ; i<n ; i++) {
            sum += Integer.parseInt(st.nextToken());
            sum = Math.max(sum, 0);
            if (sum >= m) count++;
        }
        System.out.println(count);
        br.close();
    }
}
