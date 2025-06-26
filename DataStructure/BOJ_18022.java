// BOJ - 18022
// Problem Sheet - https://www.acmicpc.net/problem/18022

import java.util.*;
import java.io.*;

public class Main {

    private static String rhyme;
    private static Deque<String> queue;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        rhyme = br.readLine();
        int n = Integer.parseInt(br.readLine());
        queue = new ArrayDeque<>(n);
        for (int i=0 ; i<n ; i++) {
            queue.add(br.readLine());
        }
        br.close();
    }

    private static String solve() {
        List<List<String>> teams = new ArrayList<>();
        teams.add(new ArrayList<>());
        teams.add(new ArrayList<>());

        String[] words = rhyme.split(" ");
        int seq = 0;
        while (!queue.isEmpty()) {
            for (int i=0 ; i<words.length-1 ; i++) {
                queue.add(queue.poll());
            }
            teams.get(seq++ % 2).add(queue.poll());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(teams.get(0).size()).append("\n");
        teams.get(0).forEach(m -> sb.append(m).append("\n"));
        sb.append(teams.get(1).size()).append("\n");
        teams.get(1).forEach(m -> sb.append(m).append("\n"));
        return sb.toString();
    }

}