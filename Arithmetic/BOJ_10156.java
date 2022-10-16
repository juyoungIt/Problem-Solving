// BOJ - 10156
// Problem Sheet - https://www.acmicpc.net/problem/10156

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] input = new int[3];
        for(int i=0 ; i<3 ; i++)
            input[i] = Integer.parseInt(st.nextToken());

        int result = input[0] * input[1] - input[2];

        System.out.println(Math.max(result, 0));

        bf.close();
        System.exit(0);
    }
}