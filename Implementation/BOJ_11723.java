// BOJ - 11723
// Problem Sheet - https://www.acmicpc.net/problem/11723

import java.util.*;
import java.io.*;

public class Main {

    static class MySet {
        boolean[] set;

        public MySet() { this.set = new boolean[21]; }

        public void add(int x) { set[x] = true; }
        public void remove(int x) { set[x] = false; }
        public boolean check(int x) { return set[x]; }
        public void toggle(int x) { set[x] = !set[x]; }
        public void all() { Arrays.fill(set, true); }
        public void empty() { Arrays.fill(set, false); }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        MySet set = new MySet();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    sb.append(set.check(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    set.toggle(Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    set.all();
                    break;
                case "empty":
                    set.empty();
                    break;
                default:
                    throw new IllegalArgumentException("invalid command...");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
