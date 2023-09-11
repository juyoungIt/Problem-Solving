// BOJ - 15663
// Problem Sheet - https://www.acmicpc.net/problem/15663

import java.util .*;
import java.io.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] numbers;
    private static int[] selected;
    private static boolean[] used;
    private static StringBuilder sb;
    private static Set<String> sequences;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        sequences = new HashSet<>();

        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        used = new boolean[N];
        numbers = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(numbers);

        generateCase(0);
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static void generateCase(int accCount) {
        StringBuilder buffer = new StringBuilder();
        if(accCount >= M) {
            Arrays.stream(selected).forEach(number -> buffer.append(number).append(" "));
            if(!sequences.contains(buffer.toString())) {
                sequences.add(buffer.toString());
                sb.append(buffer);
                sb.append("\n");
            }
        } else {
            for(int i=0 ; i<numbers.length ; i++) {
                if(!used[i]) {
                    selected[accCount] = numbers[i];
                    used[i] = true;
                    generateCase(accCount + 1);
                    used[i] = false;
                }
            }
        }
    }
}