// BOJ - 4880
// Problem Sheet - https://www.acmicpc.net/problem/4880

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int a3 = Integer.parseInt(st.nextToken());
            if(a1 == 0 && a2 == 0 && a3 == 0) {
                break;
            }
            if(findType(a1, a2, a3).equals("AP")) {
                sb.append("AP")
                        .append(" ")
                        .append(a3 + (a2 - a1))
                        .append("\n");
            } else {
                sb.append("GP")
                        .append(" ")
                        .append(a3 * (a2 / a1))
                        .append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static String findType(int a1, int a2, int a3) {
        if(a2 - a1 == a3 - a2) {
            return "AP";
        }
        return "GP";
    }
}