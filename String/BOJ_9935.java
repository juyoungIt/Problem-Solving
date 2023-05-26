// BOJ - 9935
// Problem Sheet - https://www.acmicpc.net/problem/9935

import java.io.*;

public class Main {

    private static final String NONE = "FRULA";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] message = bf.readLine().toCharArray();
        String explodeToken = bf.readLine();
        for(char letter : message) {
            sb.append(letter);
            if(sb.length() >= explodeToken.length()
                    && explodeToken.equals(sb.substring(sb.length()-explodeToken.length()))) {
                sb.setLength(sb.length()-explodeToken.length());
            }
        }

        while(sb.length() >= explodeToken.length()) {
            if(!explodeToken.equals(sb.substring(sb.length()-explodeToken.length()))) {
                break;
            }
            sb.setLength(sb.length()-explodeToken.length());
        }

        System.out.println((sb.length() > 0) ? sb : NONE);

        bf.close();
        System.exit(0);
    }
}