// BOJ - 7847
// Problem Sheet - https://www.acmicpc.net/problem/7847

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static int N;
    private static int[][] sales;
    private static Set<Integer> itemSet, storeSet;
    private static Map<String, Long> storage;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sales = new int[N][3];
        itemSet = new HashSet<>();
        storeSet = new HashSet<>();
        for (int i=0 ; i<N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sales[i][0] = Integer.parseInt(st.nextToken());
            sales[i][1] = Integer.parseInt(st.nextToken());
            sales[i][2] = Integer.parseInt(st.nextToken());
            itemSet.add(sales[i][0]);
            storeSet.add(sales[i][1]);
        }
        storage = new HashMap<>();
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<N ; i++) {
            String key = sales[i][1] + "-" + sales[i][0];
            int count = sales[i][2];
            storage.put(key, storage.getOrDefault(key, 0L) + count);
        }

        List<Integer> items = itemSet.stream().sorted().collect(Collectors.toList());
        List<Integer> stores = storeSet.stream().sorted().collect(Collectors.toList());
        sb.append("-1 ");
        items.forEach(i -> sb.append(i).append(" "));
        sb.append("\n");
        for (int store : stores) {
            sb.append(store).append(" ");
            for (int item : items) {
                String key = store + "-" + item;
                sb.append(storage.getOrDefault(key, 0L)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
