// BOJ - 5554
// Problem Sheet - https://www.acmicpc.net/problem/5554

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalSeconds = 0;
        for(int i=0 ; i<4 ; i++) {
            totalSeconds += Integer.parseInt(bf.readLine());
        }

        int minute = totalSeconds / 60;
        int second = totalSeconds % 60;
        System.out.println(minute + "\n" + second);

        bf.close();
        System.exit(0);
    }
}