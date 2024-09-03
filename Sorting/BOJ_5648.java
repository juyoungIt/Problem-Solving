// BOJ - 5648
// Problem Sheet - https://www.acmicpc.net/problem/5648

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Long> numbers = new ArrayList<>();
        StringBuilder reverser = new StringBuilder();
        boolean isFirst = true;
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                if (isFirst) {
                    isFirst = false;
                    st.nextToken();
                    continue;
                }
                reverser.append(st.nextToken()).reverse();
                numbers.add(Long.parseLong(reverser.toString()));
                reverser.setLength(0);
            }
        }

        Collections.sort(numbers);
        for (long number : numbers) {
            sb.append(number).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}