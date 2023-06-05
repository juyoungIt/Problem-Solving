// BOJ - 11816
// Problem Sheet - https://www.acmicpc.net/problem/11816

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String number = bf.readLine();

        if(number.charAt(0) == '0') {
            if(number.length() >= 2 && number.charAt(1) == 'x') {
                System.out.println(Integer.parseInt(number.substring(2), 16));
            } else {
                System.out.println(Integer.parseInt(number.substring(1), 8));
            }
        } else {
            System.out.println(number);
        }

        bf.close();
        System.exit(0);
    }
}