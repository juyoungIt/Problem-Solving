// BOJ - 31869
// Problem Sheet - https://www.acmicpc.net/problem/31869

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Promise implements Comparable<Promise> {
        private final String name;
        private final int week;
        private final int dayOfWeek;
        private final int price;

        public Promise(String name, int week, int dayOfWeek, int price) {
            this.name = name;
            this.week = week;
            this.dayOfWeek = dayOfWeek;
            this.price = price;
        }

        public String getName() { return this.name; }
        private int getWeek() { return this.week; }
        private int getDayOfWeek() { return this.dayOfWeek; }
        private int getPrice() { return this.price; }

        @Override
        public int compareTo(Promise p) {
            if (this.getWeek() == p.getWeek()) {
                return Integer.compare(this.getDayOfWeek(), p.getDayOfWeek());
            }
            return Integer.compare(this.week, p.getWeek());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Promise> promises = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int w = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            promises.add(new Promise(s, w, d, p));
        }

        Map<String, Integer> properties = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int property = Integer.parseInt(st.nextToken());
            properties.put(name, property);
        }

        promises = promises.stream()
                .filter(p -> p.getPrice() <= properties.get(p.getName()))
                .collect(Collectors.toList());
        Collections.sort(promises);

        if (promises.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        }

        int maxPromiseCount = 0;
        int curPromiseCount = 1;
        for (int i=1 ; i<promises.size() ; i++) {
            if (isSameDay(promises.get(i-1), promises.get(i))) continue;
            if (isContinuous(promises.get(i-1), promises.get(i))) {
                curPromiseCount++;
            } else {
                if (curPromiseCount > maxPromiseCount) {
                    maxPromiseCount = curPromiseCount;
                }
                curPromiseCount = 1;
            }
        }
        if (curPromiseCount > maxPromiseCount) {
            maxPromiseCount = curPromiseCount;
        }

        System.out.println(maxPromiseCount);

        br.close();
        System.exit(0);
    }

    private static boolean isSameDay(Promise prevPromise, Promise curPromise) {
        return prevPromise.getWeek() == curPromise.getWeek()
                && prevPromise.getDayOfWeek() == curPromise.getDayOfWeek();
    }

    private static boolean isContinuous(Promise prevPromise, Promise curPromise) {
        return (prevPromise.getWeek() == curPromise.getWeek()
                    && prevPromise.getDayOfWeek() + 1 == curPromise.getDayOfWeek())
                || (prevPromise.getWeek() + 1 == curPromise.getWeek()
                    && prevPromise.getDayOfWeek() == 6
                    && curPromise.getDayOfWeek() == 0);
    }
}