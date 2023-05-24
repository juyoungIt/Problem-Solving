// BOJ - 5988
// Problem Sheet - https://www.acmicpc.net/problem/5988

import java.io.*;

public class Main {

    private static final String IS_EVEN = "even";
    private static final String IS_ODD = "odd";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfNumbers = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfNumbers ; i++) {
            String number = bf.readLine();
            if(Character.getNumericValue(number.charAt(number.length()-1)) % 2 == 0) {
                sb.append(IS_EVEN).append("\n");
            } else {
                sb.append(IS_ODD).append("\n");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}