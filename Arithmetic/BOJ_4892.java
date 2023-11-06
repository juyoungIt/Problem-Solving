// BOJ - 4892
// Problem Sheet - https://www.acmicpc.net/problem/4892

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int turn = 1;
        while(true) {
            int n0 = Integer.parseInt(bf.readLine());
            if(n0 == 0) {
                break;
            }
            int n1 = 3 * n0;
            if(n1 % 2 == 0) {
                sb.append(String.format("%d. even %d\n", turn, calWhenEven(n1)));
            } else {
                sb.append(String.format("%d. odd %d\n", turn, calWhenOdd(n1)));
            }
            turn++;
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int calWhenOdd(int n1) {
        return (((n1 + 1) / 2) * 3) / 9;
    }

    private static int calWhenEven(int n1) {
        return ((n1 / 2) * 3) / 9;
    }
}