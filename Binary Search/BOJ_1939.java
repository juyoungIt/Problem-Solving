// BOJ - 1939
// Problem Sheet - https://www.acmicpc.net/problem/1939

import java.io.*;
import java.util.*;

public class Main {

    static class Bridge {
        private final int connected;
        private final int weightLimit;

        public Bridge(int connected, int weightLimit) {
            this.connected = connected;
            this.weightLimit = weightLimit;
        }

        public int getConnected() { return this.connected; }
        public int getWeightLimit() { return this.weightLimit; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Bridge>[] al = new List[n + 1];
        for (int i=1 ; i<=n ; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al[a].add(new Bridge(b, c));
            al[b].add(new Bridge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int factoryA = Integer.parseInt(st.nextToken());
        int factoryB = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = 1_000_000_000;
        int maxWeight = 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isDeliverable(al, factoryA, factoryB, mid)) {
                start = mid + 1;
                maxWeight = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(maxWeight);

        br.close();
        System.exit(0);
    }

    private static boolean isDeliverable(List<Bridge>[] al, int src, int dest, int weight) {
        Queue<Bridge> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[al.length];
        queue.add(new Bridge(src, 0));
        while (!queue.isEmpty()) {
            Bridge curBridge = queue.peek();
            for (Bridge nextBridge : al[curBridge.getConnected()]) {
                int nextIsland = nextBridge.getConnected();
                int weightLimit = nextBridge.getWeightLimit();
                if (!isVisited[nextIsland] && weight <= weightLimit) {
                    isVisited[nextIsland] = true;
                    queue.add(nextBridge);
                    if (nextIsland == dest) {
                        return true;
                    }
                }
            }
            queue.poll();
        }
        return false;
    }
}