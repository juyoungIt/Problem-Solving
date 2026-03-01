// BOJ - 17094
// Problem Sheet - https://www.acmicpc.net/problem/17094

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int count2 = 0, countE = 0;
        String s = br.readLine();
        for (int i=0 ; i<len ; i++) {
            char c = s.charAt(i);
            if (c == '2') count2++;
            else countE++;
        }
        if (count2 == countE) System.out.println("yee");
        else System.out.println(count2 < countE ? "e" : 2);
        br.close();
    }
}
