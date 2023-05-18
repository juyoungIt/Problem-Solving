// BOJ - 25372
// Problem Sheet - https://www.acmicpc.net/problem/25372

import java.io.*;

public class Main {

    private static final String VALID = "yes";
    private static final String INVALID = "no";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfPasswords = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfPasswords ; i++) {
            String password = bf.readLine();
            if(password.length() >= 6 && password.length() <= 9) {
                sb.append(VALID).append("\n");
            } else {
                sb.append(INVALID).append("\n");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}