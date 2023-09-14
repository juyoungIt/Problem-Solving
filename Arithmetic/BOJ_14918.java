// BOJ - 14918
// Problem Sheet - https://www.acmicpc.net/problem/14918

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(a + b);

        bf.close();
        System.exit(0);
    }
}