// BOJ - 2985
// Problem Sheet - https://www.acmicpc.net/problem/2985

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<4 ; i++) {
            if(i == 0 && b + c == a) {
                System.out.printf("%d=%d+%d\n", a, b, c);
            } else if(i == 1 && b - c == a) {
                System.out.printf("%d=%d-%d\n", a, b, c);
            } else if(i == 2 && b * c == a) {
                System.out.printf("%d=%d*%d\n", a, b, c);
            } else if(i == 3 && b / c == a) {
                System.out.printf("%d=%d/%d\n", a, b, c);
            } else if(i == 0 && a + b == c) {
                System.out.printf("%d+%d=%d\n", a, b, c);
            } else if(i == 1 && a - b == c) {
                System.out.printf("%d-%d=%d\n", a, b, c);
            } else if(i == 2 && a * b == c) {
                System.out.printf("%d*%d=%d\n", a, b, c);
            } else if(i == 3 && a / b == c) {
                System.out.printf("%d/%d=%d\n", a, b, c);
            }
        }

        bf.close();
        System.exit(0);
    }
}