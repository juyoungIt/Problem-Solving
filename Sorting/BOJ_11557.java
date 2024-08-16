// BOJ - 11557
// Problem Sheet - https://www.acmicpc.net/problem/11557

import java.util.*;
import java.io.*;

public class Main {

    static class University {
        private final String name;
        private final int quantity;

        public University(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() { return this.name; }
        public int getQuantity() { return this.quantity; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            int n = Integer.parseInt(br.readLine());
            University[] universities = new University[n];
            for (int j=0 ; j<n ; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int quantity = Integer.parseInt(st.nextToken());
                universities[j] = new University(name, quantity);
            }
            Arrays.sort(universities, (u1, u2) -> u2.getQuantity() - u1.getQuantity());
            sb.append(universities[0].getName()).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}