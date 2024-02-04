// BOJ - 6131
// Problem Sheet - https://www.acmicpc.net/problem/6131

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int validPairCnt = 0;

        int n = Integer.parseInt(br.readLine());
        for(int a=1 ; a<=500 ; a++) {
            for(int b=1 ; b<=a ; b++) {
                if(Math.abs(Math.pow(a, 2) - Math.pow(b, 2)) == n) {
                    validPairCnt++;
                }
            }
        }

        System.out.println(validPairCnt);

        br.close();
        System.exit(0);
    }
}