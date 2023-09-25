// BOJ - 26082
// Problem Sheet - https://www.acmicpc.net/problem/26082

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(3 * B * C / A);

        bf.close();
        System.exit(0);
    }
}