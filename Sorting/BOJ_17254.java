// BOJ - 17254
// Problem Sheet - https://www.acmicpc.net/problem/17254

import java.util.*;
import java.io.*;

public class Main {

    static class Log implements Comparable<Log> {
        private final int keyboard;
        private final int time;
        private final char input;

        public Log(int keyboard, int time, char input) {
            this.keyboard = keyboard;
            this.time = time;
            this.input = input;
        }

        public int getKeyboard() { return this.keyboard; }
        public int getTime() { return this.time; }
        public char getInput() { return this.input; }

        @Override
        public int compareTo(Log l) {
            if (this.time == l.getTime()) {
                return this.keyboard - l.getKeyboard();
            }
            return this.time - l.getTime();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Log> logs = new ArrayList<>(m);
        for (int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            logs.add(new Log(a, b, c));
        }
        Collections.sort(logs);
        logs.forEach(l -> sb.append(l.getInput()));
        System.out.println(sb);

        br.close();
    }
}