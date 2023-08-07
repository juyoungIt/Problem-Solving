// BOJ - 10984
// Problem Sheet - https://www.acmicpc.net/problem/10984

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            int N = Integer.parseInt(bf.readLine());
            int totalCredits = 0;
            double gpa = 0;
            for(int j=0 ; j<N ; j++) {
                st = new StringTokenizer(bf.readLine());
                int C = Integer.parseInt(st.nextToken());
                double G = Double.parseDouble(st.nextToken());
                totalCredits += C;
                gpa += C * G;
            }
            gpa /= totalCredits;
            sb.append(totalCredits)
                    .append(" ")
                    .append(String.format("%.1f", gpa))
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}