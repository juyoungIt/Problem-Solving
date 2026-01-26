// BOJ - 26736
// Problem Sheet - https://www.acmicpc.net/problem/26736

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String log = br.readLine();
        int a = 0, b = 0;
        for (int i=0 ; i<log.length() ; i++) {
            if (log.charAt(i) == 'A') {
                a++;
            } else {
                b++;
            }
        }
        System.out.printf("%d : %d\n", a, b);
        br.close();
    }
}
