// BOJ - 2857
// Problem Sheet - https://www.acmicpc.net/problem/2857

import java.io.*;

public class Main {

    private static final String FAILED = "HE GOT AWAY!";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i=1 ; i<=5 ; i++) {
            if(bf.readLine().contains("FBI")) {
                sb.append(i).append(" ");
            }
        }

        System.out.println((sb.length() > 0) ? sb : FAILED);

        bf.close();
        System.exit(0);
    }
}