// BOJ - 5613
// Problem Sheet - https://www.acmicpc.net/problem/5613

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        String token = "";
        String operator = "+";
        for(int i=0 ; !token.equals("=") ; i++) {
            token = bf.readLine();
            if(i % 2 != 0) {
                operator = token;
            } else {
                if(operator.charAt(0) == '+') {
                    result += Integer.parseInt(token);
                } else if(operator.charAt(0) == '-') {
                    result -= Integer.parseInt(token);
                } else if(operator.charAt(0) == '*') {
                    result *= Integer.parseInt(token);
                } else if(operator.charAt(0) == '/') {
                    result /= Integer.parseInt(token);
                }
            }
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}