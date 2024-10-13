// BOJ - 2910
// Problem Sheet - https://www.acmicpc.net/problem/2910

import java.util.*;
import java.io.*;

public class Main {

    static class Number {
        private final int value;
        private int count;

        public Number(int value) {
            this.value = value;
            this.count = 0;
        }

        public int getValue() { return this.value; }
        public int getCount() { return this.count; }
        public void addCount() { this.count++; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] message = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Number> numbers = new ArrayList<>();
        Map<Integer, Number> numberMapper = new HashMap<>();
        for (int number : message) {
            if (!numberMapper.containsKey(number)) {
                numberMapper.put(number, new Number(number));
                numbers.add(numberMapper.get(number));
            }
            numberMapper.get(number).addCount();
        }
        numbers.sort((n1, n2) -> n2.getCount() - n1.getCount());

        for (Number number : numbers) {
            for (int i=0 ; i<number.getCount() ; i++) {
                sb.append(number.getValue()).append(" ");
            }
        }
        System.out.println(sb);

        br.close();
    }
}