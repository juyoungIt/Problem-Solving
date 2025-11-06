// BOJ - 17388
// Problem Sheet - https://www.acmicpc.net/problem/17388

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        if (s + k + h >= 100) {
            System.out.println("OK");
        } else {
            if (s < k && s < h) System.out.println("Soongsil");
            else if (k < s && k < h) System.out.println("Korea");
            else System.out.println("Hanyang");
        }
    }
}
