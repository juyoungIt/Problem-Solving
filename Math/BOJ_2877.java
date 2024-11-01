// BOJ - 2877
// Problem Sheet - https://www.acmicpc.net/problem/2877

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        String bi = Integer.toBinaryString(K + 1)
                .replace('0', '4')
                .replace('1', '7');
        System.out.println(bi.substring(1));

        br.close();
    }
}