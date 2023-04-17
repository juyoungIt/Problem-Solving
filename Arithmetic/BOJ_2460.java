// BOJ - 2460
// Problem Sheet - https://www.acmicpc.net/problem/2460

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int currentPassengers = 0;
        int maxNumberOfPassengers = 0;
        for(int i=0 ; i<10 ; i++) {
            st = new StringTokenizer(bf.readLine());
            int leaveCount = Integer.parseInt(st.nextToken());
            int boardingCount = Integer.parseInt(st.nextToken());
            currentPassengers += (boardingCount - leaveCount);
            if(maxNumberOfPassengers < currentPassengers) {
                maxNumberOfPassengers = currentPassengers;
            }
        }

        System.out.println(maxNumberOfPassengers);

        bf.close();
        System.exit(0);
    }
}