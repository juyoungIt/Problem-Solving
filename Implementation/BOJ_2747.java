// BOJ - 2747
// Problem Sheet - https://www.acmicpc.net/problem/2747

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] fibos = new int[n + 1];
        fibos[0] = 0;
        fibos[1] = 1;

        if(n > 1) {
            for(int i=2 ; i<=n ; i++) {
                fibos[i] = fibos[i - 2] + fibos[i - 1];
            }
        }

        System.out.println(fibos[n]);

        bf.close();
        System.exit(0);
    }
}