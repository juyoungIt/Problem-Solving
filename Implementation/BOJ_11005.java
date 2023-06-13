// BOJ - 11005
// Problem Sheet - https://www.acmicpc.net/problem/11005

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        char[] digits = new char[36];
        for(int i=0 ; i<=35 ; i++) {
            if(i<10) {
                digits[i] = Integer.toString(i).charAt(0);
            } else {
                digits[i] = (char)(i+55);
            }
        }

        int decimalNumber = Integer.parseInt(st.nextToken());
        int targetSystem = Integer.parseInt(st.nextToken());
        while(decimalNumber/targetSystem > 0) {
            sb.insert(0, digits[decimalNumber%targetSystem]);
            decimalNumber /= targetSystem;
        }
        sb.insert(0, digits[decimalNumber]);

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}