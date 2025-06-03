// BOJ - 33691
// Problem Sheet - https://www.acmicpc.net/problem/33691

import java.util.*;
import java.io.*;

public class Main {

    static class Container implements Comparable<Container> {
        private final String name;
        private int usedAt;
        private boolean isFixed;

        public Container(String name, int usedAt) {
            this.name = name;
            this.usedAt = usedAt;
        }

        public String getName() { return this.name; }
        public int getUsedAt() { return this.usedAt; }
        public boolean isFixed() { return this.isFixed; }
        public void setUsedAt(int usedAt) { this.usedAt = usedAt; }
        public void setFixed(boolean fixed) { this.isFixed = fixed; }

        @Override
        public int compareTo(Container c) {
            if (this.isFixed() == c.isFixed()) return Integer.compare(c.getUsedAt(), this.usedAt);
            else if (this.isFixed()) return -1;
            else return 1;
        }
    }

    private static Map<String, Container> containers;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        containers = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            String container = br.readLine();
            if (!containers.containsKey(container)) {
                containers.put(container, new Container(container, i));
            } else {
                containers.get(container).setUsedAt(i);
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i=0 ; i<k ; i++) {
            String container = br.readLine();
            containers.get(container).setFixed(true);
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        List<Container> result = new ArrayList<>(containers.values());
        Collections.sort(result);
        for (Container container : result) {
            sb.append(container.getName()).append("\n");
        }
        return sb.toString();
    }

}