// BOJ - 5692
// Problem Sheet - https://www.acmicpc.net/problem/5692

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String number = bf.readLine();
            if(Integer.parseInt(number) == 0) {
                break;
            }
            int sum = 0;
            for(int i=1 ; i<=number.length() ; i++) {
                sum += Integer.parseInt(String.valueOf(number.charAt(number.length() - i))) * getFactorialValue(i);
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getFactorialValue(int n) {
        return n == 0 ? 1 : n * getFactorialValue(n-1);
    }
}