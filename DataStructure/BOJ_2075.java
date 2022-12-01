// BOJ - 2075
// Problem Sheet - https://www.acmicpc.net/problem/2075

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<n ; j++)
                numbers.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0 ; i<n-1 ; i++)
            numbers.poll();

        System.out.println(numbers.peek());

        bf.close();
        System.exit(0);
    }
}