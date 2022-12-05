// BOJ - 2910
// Problem Sheet - https://www.acmicpc.net/problem/2910

import java.util.*;
import java.io.*;

public class Main {

    static class NumberInfo implements Comparable<NumberInfo> {
        private int number;
        private int count;

        public NumberInfo(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public int getNumber() { return this.number; }
        public int getCount() { return this.count; }

        @Override
        public int compareTo(NumberInfo numberInfo) {
            return Integer.compare(this.count, numberInfo.getCount()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<Integer, Integer> countMapper = new LinkedHashMap<>(); // 각 수의 사용된 횟수를 유지
        List<NumberInfo> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder(); // 출력할 결과를 저장함

        int n = Integer.parseInt(st.nextToken()); // 메시지의 길이
        int c = Integer.parseInt(st.nextToken()); // 크기 제한 숫자

        // 수열의 빈도수 정보를 종합함
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(!countMapper.containsKey(number)) countMapper.put(number, 1);
            else countMapper.put(number, countMapper.get(number) + 1);
        }

        // 종합된 빈도 수를 바탕으로 정렬함
        for(Map.Entry<Integer, Integer> number : countMapper.entrySet())
            numbers.add(new NumberInfo(number.getKey(), number.getValue()));
        Collections.sort(numbers); // 빈도수 기준으로 오름차순 정렬함

        // 종합된 정렬 기준을 출력
        for(NumberInfo number : numbers)
            for(int i=0 ; i<number.getCount() ; i++)
                sb.append(number.getNumber()).append(' ');
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}