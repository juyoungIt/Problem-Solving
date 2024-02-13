// BOJ - 6322
// Problem Sheet - https://www.acmicpc.net/problem/6322

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT_A = "Triangle #%d\n%c = %.3f\n\n";
    private static final String OUTPUT_FORMAT_B = "Triangle #%d\nImpossible.\n\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testIdx = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0) break;
            char unknown = getUnknown(a, b, c);
            double solution = getSolution(a, b, c);
            if(solution > 0) {
                sb.append(String.format(OUTPUT_FORMAT_A, testIdx, unknown, solution));
            } else {
                sb.append(String.format(OUTPUT_FORMAT_B, testIdx));
            }
            testIdx++;
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static double getSolution(int a, int b, int c) {
        if(a == -1) return Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
        else if(b == -1) return Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
        else return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    private static char getUnknown(int a, int b, int c) {
        if(a == -1) return 'a';
        else if(b == -1) return 'b';
        else if(c == -1) return 'c';
        else throw new IllegalArgumentException();
    }
}