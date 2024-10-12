// BOJ - 29155
// Problem Sheet - https://www.acmicpc.net/problem/29155

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=5 ; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> problems = new ArrayList<>(6);
        problems.add(null);
        for (int i=0 ; i<5 ; i++) {
            problems.add(new ArrayList<>());
        }
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            problems.get(level).add(time);
        }

        for (int i=1 ; i<=5 ; i++) {
            List<Integer> range = problems.get(i)
                    .stream()
                    .sorted()
                    .limit(p[i])
                    .collect(Collectors.toList());
            problems.set(i, range);
        }

        int totalTime = 0;
        int prevLevel = -1;
        int prevTime = -1;
        for (int i=1 ; i<=5 ; i++) {
            for (int j=0 ; j<problems.get(i).size() ; j++) {
                if (prevLevel != -1 && prevTime != -1) {
                    totalTime += getRestTime(prevLevel, prevTime, i, problems.get(i).get(j));
                }
                totalTime += problems.get(i).get(j);
                prevLevel = i;
                prevTime = problems.get(i).get(j);
            }
        }

        System.out.println(totalTime);

        br.close();
    }

    private static int getRestTime(int levelA, int timeA, int levelB, int timeB) {
        if (levelA == levelB) {
            return Math.abs(timeA - timeB);
        }
        return 60;
    }
}