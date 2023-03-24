// BOJ - 11382
// Problem Sheet - https://www.acmicpc.net/problem/11382

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long result = 0;

        for(int i=0 ; i<3 ; i++) {
            result += Long.parseLong(st.nextToken());
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}