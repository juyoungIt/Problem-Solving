// BOJ - 2896
// Problem Sheet - https://www.acmicpc.net/problem/2896

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] juice = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        double[] ratio = Arrays.stream(br.readLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double multiplier = Math.min(
                (double) juice[0] / ratio[0],
                Math.min((double) juice[1] / ratio[1],
                        (double) juice[2] / ratio[2])
        );
        double[] result = new double[3];
        for (int i=0 ; i<3 ; i++) {
            ratio[i] = ratio[i] * multiplier;
            result[i] = juice[i] - ratio[i];
        }

        if (result[0] == (int) result[0]) sb.append((int) result[0]).append(" ");
        else sb.append(String.format("%.6f", result[0])).append(" ");
        if (result[1] == (int) result[1]) sb.append((int) result[1]).append(" ");
        else sb.append(String.format("%.6f", result[1])).append(" ");
        if (result[2] == (int) result[2]) sb.append((int) result[2]);
        else sb.append(String.format("%.6f", result[2]));

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}