// BOJ - 19592
// Problem Sheet - https://www.acmicpc.net/problem/19592

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int X = Integer.parseInt(input[1]);
            int Y = Integer.parseInt(input[2]);
            input = br.readLine().split(" ");
            double[] records = new double[N - 1];
            for (int i=0 ; i<N-1 ; i++) {
                int vi = Integer.parseInt(input[i]);
                records[i] = (double) X / vi;
            }
            Arrays.sort(records);
            int mySpeed = Integer.parseInt(input[N - 1]);
            sb.append(getOptBoostSpeed(records[0], mySpeed, X, Y)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int getOptBoostSpeed(double competitor, int speed, int X, int Y) {
        int start = 1;
        int end = Y;
        int optBoostSpeed = -1;
        if (competitor > (double) X / speed) {
            return 0;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            double myRecord = ((double) (X - mid) / speed) + 1;
            if (competitor > myRecord) {
                optBoostSpeed = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return optBoostSpeed;
    }
}