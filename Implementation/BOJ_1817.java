// BOJ - 1817
// Problem Sheet - https://www.acmicpc.net/problem/1817

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] books = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }
        int boxCount = 1;
        int capacity = m;
        for (int book : books) {
            if (capacity >= book) {
                capacity -= book;
            } else {
                capacity = m - book;
                boxCount++;
            }
        }
        System.out.println(boxCount);
        br.close();
    }
}
