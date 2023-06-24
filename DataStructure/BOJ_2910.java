// BOJ - 18870
// Problem Sheet - https://www.acmicpc.net/problem/18870

import java.util.*;
import java.io.*;

public class Main {

    static class Number implements Comparable<Number> {
        private final String value;
        private final int useCount;

        public Number(String value, int useCount) {
            this.value = value;
            this.useCount = useCount;
        }

        public String getValue() { return this.value; }
        public int getUseCount() { return this.useCount; }

        @Override
        public int compareTo(Number number) {
            return number.getUseCount() - this.useCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int lenghtOfMessage  = Integer.parseInt(st.nextToken());
        int maxValue = Integer.parseInt(st.nextToken());
        Map<String, Integer> countMapper = new LinkedHashMap<>();
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<lenghtOfMessage ; i++) {
            String number = st.nextToken();
            countMapper.put(number, countMapper.getOrDefault(number, 0) + 1);
        }

        List<Number> numbers = new LinkedList<>();
        for(Map.Entry<String, Integer> entry : countMapper.entrySet()) {
            numbers.add(new Number(entry.getKey(), entry.getValue()));
        }
        Collections.sort(numbers);

        for(Number number : numbers) {
            for(int i=0 ; i<number.getUseCount() ; i++) {
                sb.append(number.getValue()).append(" ");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}