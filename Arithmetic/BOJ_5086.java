// BOJ - 5086
// Problem Sheet - https://www.acmicpc.net/problem/5086

import java.util.*;
import java.io.*;

public class Main {

    private static final String FACTOR = "factor";
    private static final String MULTIPLE = "multiple";
    private static final String NEITHER = "neither";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(bf.readLine());
            int numberA = Integer.parseInt(st.nextToken());
            int numberB = Integer.parseInt(st.nextToken());
            if(numberA ==0 && numberB == 0) {
                break;
            } else if(numberB % numberA == 0) {
                sb.append(FACTOR).append("\n");
            } else if(numberA % numberB == 0) {
                sb.append(MULTIPLE).append("\n");
            } else {
                sb.append(NEITHER).append("\n");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}