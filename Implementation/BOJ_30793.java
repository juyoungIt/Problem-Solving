// BOJ - 30793
// Problem Sheet - https://www.acmicpc.net/problem/30793

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int px = Integer.parseInt(st.nextToken());
        int rx = Integer.parseInt(st.nextToken());
        double vx = (double) px / rx;
        if (vx < 0.2) System.out.println("weak");
        else if (vx < 0.4) System.out.println("normal");
        else if (vx < 0.6) System.out.println("strong");
        else System.out.println("very strong");
        br.close();
    }
}
