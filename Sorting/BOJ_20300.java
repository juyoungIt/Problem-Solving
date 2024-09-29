// BOJ - 20300
// Problem Sheet - https://www.acmicpc.net/problem/20300

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] loss = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        Arrays.sort(loss);

        long m = 0;
        if (n % 2 == 0) {
            for (int i=0 ; i<n/2 ; i++) {
                if (m < loss[i] + loss[n-1-i]) {
                    m = loss[i] + loss[n-1-i];
                }
            }
        } else {
            m = loss[n-1];
            for (int i=0 ; i<n/2 ; i++) {
                if (m < loss[i] + loss[n-2-i]) {
                    m = loss[i] + loss[n-2-i];
                }
            }
        }

        System.out.println(m);

        br.close();
        System.exit(0);
    }
}