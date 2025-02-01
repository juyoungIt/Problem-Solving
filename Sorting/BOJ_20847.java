// BOJ - 20847
// Problem Sheet - https://www.acmicpc.net/problem/20847

import java.util.*;
import java.io.*;

public class Main {

    static class Friend {
        private final String name;
        private final int priority;
        private final String birthDate;

        public Friend(String name, int priority, String birthDate) {
            this.name = name;
            this.priority = priority;
            this.birthDate = birthDate;
        }

        public String getName() { return this.name; }
        public int getPriority() { return this.priority; }
        public String getBirthDate() { return this.birthDate; }
    }

    private static int K;
    private static Map<String, Friend> friendMapper;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        friendMapper = new HashMap<>();
        for (int i=0 ; i<K ; i++) {
            String[] row = br.readLine().split(" ");
            if (!friendMapper.containsKey(row[2])
                    || friendMapper.get(row[2]).getPriority() < Integer.parseInt(row[1])) {
                friendMapper.put(row[2], new Friend(row[0], Integer.parseInt(row[1]), row[2]));
            }
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        sb.append(friendMapper.size()).append("\n");
        friendMapper.values()
                .stream()
                .sorted(Comparator.comparing(Friend::getName))
                .forEach(f -> sb.append(f.getName()).append("\n"));
        return sb.toString();
    }
}