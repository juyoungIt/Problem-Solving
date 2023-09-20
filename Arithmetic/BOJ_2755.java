// BOJ - 2755
// Problem Sheet - https://www.acmicpc.net/problem/2755

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> gradeMapper = new HashMap<>();
        initGradeMapper(gradeMapper);

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        double totalSum = 0;
        int totalBase = 0;
        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int base = Integer.parseInt(st.nextToken());
            totalBase += base;
            double grade = gradeMapper.get(st.nextToken());
            totalSum += base * grade;
        }

        System.out.printf("%.02f%n", totalSum / totalBase);

        bf.close();
        System.exit(0);
    }

    private static void initGradeMapper(Map<String, Double> mapper) {
        mapper.put("A+", 4.3);
        mapper.put("A0", 4.0);
        mapper.put("A-", 3.7);
        mapper.put("B+", 3.3);
        mapper.put("B0", 3.0);
        mapper.put("B-", 2.7);
        mapper.put("C+", 2.3);
        mapper.put("C0", 2.0);
        mapper.put("C-", 1.7);
        mapper.put("D+", 1.3);
        mapper.put("D0", 1.0);
        mapper.put("D-", 0.7);
        mapper.put("F", 0.0);
    }
}