// BOJ - 17174
// Problem Sheet - https://www.acmicpc.net/problem/17174

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = n;
        while(n / m > 0) {
            sum += n / m;
            n /= m;
        }

        System.out.println(sum);

        br.close();
        System.exit(0);
    }
}