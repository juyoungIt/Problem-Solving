// BOJ - 5691
// Problem Sheet - https://www.acmicpc.net/problem/5691

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int numberA = Integer.parseInt(st.nextToken());
            int numberB = Integer.parseInt(st.nextToken());
            if(numberA == 0 && numberB == 0) {
                break;
            }
            int low = Math.min(numberA, numberB);
            int high = Math.max(numberA, numberB);
            sb.append(low - (high - low)).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}