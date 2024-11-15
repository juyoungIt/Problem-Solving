// BOJ - 16200
// Problem Sheet - https://www.acmicpc.net/problem/16200

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int teamCount = 1;
        int teamSize = N;
        int curTeamSize = 0;
        for (int i=N-1 ; i>=0 ; i--) {
            teamSize = Math.min(teamSize, arr[i]);
            curTeamSize++;
            if (curTeamSize > teamSize) {
                teamCount++;
                teamSize = arr[i];
                curTeamSize = 1;
            }
        }

        System.out.println(teamCount);
        br.close();
    }
}