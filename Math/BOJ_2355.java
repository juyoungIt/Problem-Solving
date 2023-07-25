// BOJ - 2355
// Problem Sheet - https://www.acmicpc.net/problem/2355

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long result = ((A + B) * (Math.abs(A - B) + 1)) / 2;
        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}