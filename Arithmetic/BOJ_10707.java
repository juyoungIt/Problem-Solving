// BOJ - 10707
// Problem Sheet - https://www.acmicpc.net/problem/10707

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(bf.readLine());
        int B = Integer.parseInt(bf.readLine());
        int C = Integer.parseInt(bf.readLine());
        int D = Integer.parseInt(bf.readLine());
        int P = Integer.parseInt(bf.readLine());

        int chargeX = P * A;
        int chargeY = (P <= C) ? B : (B + D * (P - C));

        System.out.println(Math.min(chargeX, chargeY));

        bf.close();
        System.exit(0);
    }
}