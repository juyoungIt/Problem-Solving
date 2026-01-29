// BOJ - 34726
// Problem Sheet - https://www.acmicpc.net/problem/34726

import java.util.*;
import java.io.*;

public class Main {

    static class Driver {
        String name;
        int ti;

        public Driver(String name, int ti) {
            this.name = name;
            this.ti = ti;
        }

        @Override
        public String toString() {
            return "Driver{" +
                    "name='" + name + '\'' +
                    ", ti=" + ti +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Driver[] drivers = new Driver[n];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int ti = Integer.parseInt(st.nextToken());
            drivers[i] = new Driver(name, ((i > 0 ? drivers[i - 1].ti : 0) + ti) % t);
        }
        Arrays.sort(drivers, Comparator.comparingInt(d -> d.ti));
        List<String> drs = new ArrayList<>();
        for (int i=1 ; i<n ; i++) {
            int diff = drivers[i].ti - drivers[i - 1].ti;
            if (0 < diff && diff <= 1_000) drs.add(drivers[i].name);
        }
        int diff = t - drivers[n - 1].ti;
        if (0 < diff && diff <= 1_000) drs.add(drivers[0].name);
        Collections.sort(drs);
        for (String name : drs) {
            sb.append(name).append(" ");
        }
        if (drs.isEmpty()) System.out.println(-1);
        else System.out.println(sb);
        br.close();
    }
}
