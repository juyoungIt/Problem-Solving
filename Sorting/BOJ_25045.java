// BOJ - 25045
// Problem Sheet - https://www.acmicpc.net/problem/25045

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        List<Integer> A = new ArrayList<>(N);
        List<Integer> B = new ArrayList<>(M);

        input = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            A.add(Integer.parseInt(input[i]));
        }
        input = br.readLine().split(" ");
        for (int i=0 ; i<M ; i++) {
            B.add(Integer.parseInt(input[i]));
        }

        A.sort(Collections.reverseOrder());
        Collections.sort(B);

        long totalSatisfaction = 0;
        for (int i=0 ; i<Math.min(N, M) ; i++) {
            int satisfaction = A.get(i) - B.get(i);
            if (satisfaction < 0) break;
            totalSatisfaction += satisfaction;
        }

        System.out.println(totalSatisfaction);
        br.close();
    }
}