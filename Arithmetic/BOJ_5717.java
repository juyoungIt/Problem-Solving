// BOJ - 5717
// Problem Sheet - https://www.acmicpc.net/problem/5717

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(bf.readLine());
            int boys = Integer.parseInt(st.nextToken());
            int girls = Integer.parseInt(st.nextToken());
            if(boys == 0 && girls == 0) {
                break;
            }
            sb.append(boys + girls).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}