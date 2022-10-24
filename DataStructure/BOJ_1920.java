// BOJ - 1920
// Problem Sheet - https://www.acmicpc.net/problem/1920

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            set.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(bf.readLine());
        int[] answers = new int[m];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<m ; i++)
            answers[i] = (set.contains(Integer.parseInt(st.nextToken()))) ? 1 : 0;

        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}