// BOJ - 30794
// Problem Sheet - https://www.acmicpc.net/problem/30794

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lv = Integer.parseInt(st.nextToken());
        String judgement = st.nextToken();

        switch (judgement) {
            case "miss":
                System.out.println(0);
                break;
            case "bad":
                System.out.println(200 * lv);
                break;
            case "cool":
                System.out.println(400 * lv);
                break;
            case "great":
                System.out.println(600 * lv);
                break;
            case "perfect":
                System.out.println(1000 * lv);
                break;
        }

        br.close();
        System.exit(0);
    }
}