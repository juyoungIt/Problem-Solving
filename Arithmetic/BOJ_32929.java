// BOJ - 32929
// Problem Sheet - https://www.acmicpc.net/problem/32939

import java.io.*;

public class Main {

    private static final String str = "UOS";

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        System.out.println(str.charAt((x - 1) % 3));
        br.close();
    }
}
