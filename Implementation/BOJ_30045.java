// BOJ - 30045
// Problem Sheet - https://www.acmicpc.net/problem/30045

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n-- > 0) {
            String sentence = br.readLine();
            for (int i=0 ; i<sentence.length()-1 ; i++) {
                String token = sentence.substring(i, i + 2);
                if ("OI".equals(token) || "01".equals(token)) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
