// BOJ - 10874
// Problem Sheet - https://www.acmicpc.net/problem/10874

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[] solution = new int[11];
            for (int i=1 ; i<=10 ; i++) {
                solution[i] = (i - 1) % 5 + 1;
            }
            for (int i=1 ; i<=n ; i++) {
                st = new StringTokenizer(br.readLine());
                boolean isPerfect = true;
                for (int j=1 ; j<=10 ; j++) {
                    if (solution[j] != Integer.parseInt(st.nextToken())) {
                        isPerfect = false;
                        break;
                    }
                }
                if (isPerfect) sb.append(i).append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
