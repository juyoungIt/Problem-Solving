// BOJ - 25238
// Problem Sheet - https://www.acmicpc.net/problem/25238

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(getActualDefencePower(a, b) >= 100) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

        bf.close();
        System.exit(0);
    }

    private static double getActualDefencePower(int a, int b) {
        return a * ((double)(100 - b) / 100);
    }
}