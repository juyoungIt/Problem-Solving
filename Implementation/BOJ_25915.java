// BOJ - 25915
// Problem Sheet - https://www.acmicpc.net/problem/25915

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = "ILOVEYONSEI";
        char c = br.readLine().charAt(0);
        int dist = Math.abs(c - password.charAt(0));
        for (int i=0 ; i<password.length()-1 ; i++) {
            dist += Math.abs(password.charAt(i) - password.charAt(i + 1));
        }
        System.out.println(dist);
        br.close();
    }
}
