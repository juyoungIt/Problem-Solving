// BOJ - 13416
// Problem Sheet - https://www.acmicpc.net/problem/13416

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            int days = Integer.parseInt(br.readLine());
            int totalProfits = 0;
            for(int j=0 ; j<days ; j++) {
                int[] profits = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                totalProfits += getBestCase(profits);
            }
            sb.append(totalProfits).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getBestCase(int[] profits) {
        OptionalInt maxProfit = Arrays.stream(profits).max();
        if(maxProfit.isEmpty() || maxProfit.getAsInt() <= 0) {
            return 0;
        }
        return maxProfit.getAsInt();
    }
}