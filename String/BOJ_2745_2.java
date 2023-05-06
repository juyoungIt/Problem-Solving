// BOJ - 2745
// Problem Sheet - https://www.acmicpc.net/problem/2745

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int decimalNumber = 0;

        Map<Character, Integer> valueMapper = new HashMap<>();
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0 ; i<digits.length() ; i++) {
            valueMapper.put(digits.charAt(i), i);
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        String number = st.nextToken();
        int base = Integer.parseInt(st.nextToken());
        for(int i=0 ; i<number.length() ; i++) {
            decimalNumber += valueMapper.get(number.charAt(i)) * (int)Math.pow(base, number.length()-i-1);
        }

        System.out.println(decimalNumber);

        bf.close();
        System.exit(0);
    }
}