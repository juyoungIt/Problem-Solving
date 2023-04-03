// BOJ - 9728
// Problem Sheet - https://www.acmicpc.net/problem/9728

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            st = new StringTokenizer(bf.readLine());

            int numberOfElements = Integer.parseInt(st.nextToken());
            int targetValue = Integer.parseInt(st.nextToken());
            List<Integer> elements = new ArrayList<>(numberOfElements);
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<numberOfElements ; j++) {
                elements.add(Integer.parseInt(st.nextToken()));
            }

            int start = 0;
            int end = numberOfElements-1;
            int count = 0;

            while(start < end) {
                if(elements.get(start) + elements.get(end) > targetValue) {
                    end--;
                } else if(elements.get(start) + elements.get(end) < targetValue) {
                    start++;
                } else {
                    start++;
                    count++;
                }
            }

            sb.append("Case #")
                    .append(i+1)
                    .append(": ")
                    .append(count)
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}