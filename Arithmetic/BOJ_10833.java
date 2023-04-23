// BOJ - 10833
// Problem Sheet - https://www.acmicpc.net/problem/10833

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int totalRests = 0;

        int numberOfSchools = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfSchools ; i++) {
            st = new StringTokenizer(bf.readLine());
            int numberOfStudents  = Integer.parseInt(st.nextToken());
            int numberOfApples = Integer.parseInt(st.nextToken());
            totalRests += numberOfApples % numberOfStudents;
        }

        System.out.println(totalRests);

        bf.close();
        System.exit(0);
    }
}