// BOJ - 2745
// Problem Sheet - https://www.acmicpc.net/problem/2745

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String number = st.nextToken();
        int base = Integer.parseInt(st.nextToken());

        System.out.println(Integer.parseInt(number, base));

        bf.close();
        System.exit(0);
    }
}