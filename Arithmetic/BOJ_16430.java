// BOJ - 16430
// Problem Sheet - https://www.acmicpc.net/problem/16430

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int numberA = Integer.parseInt(st.nextToken());
        int numberB = Integer.parseInt(st.nextToken());

        System.out.println(numberB-numberA + " " + numberB);

        bf.close();
        System.exit(0);
    }
}