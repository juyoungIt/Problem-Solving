// BOJ - 25206
// Problem Sheet - https://www.acmicpc.net/problem/25206

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double totalSumOfLectures = 0;
        double totalSumOfGrades = 0;
        Map<String, Double> letterGradeMapper = new HashMap<>();
        letterGradeMapper.put("A+", 4.5);
        letterGradeMapper.put("A0", 4.0);
        letterGradeMapper.put("B+", 3.5);
        letterGradeMapper.put("B0", 3.0);
        letterGradeMapper.put("C+", 2.5);
        letterGradeMapper.put("C0", 2.0);
        letterGradeMapper.put("D+", 1.5);
        letterGradeMapper.put("D0", 1.0);
        letterGradeMapper.put("F", 0.0);

        for(int i=0 ; i<20 ; i++) {
            st = new StringTokenizer(bf.readLine());
            st.nextToken();
            double point = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(isLetterGradeSystem(grade)) {
                totalSumOfLectures += point;
                totalSumOfGrades += point * letterGradeMapper.get(grade);
            } else {
                if(!isPassFailGradeSystem(grade)) {
                    throw new IllegalArgumentException("Illegal Grade Argument");
                }
            }
        }

        System.out.printf("%.6f", totalSumOfGrades / totalSumOfLectures);

        bf.close();
        System.exit(0);
    }

    private static boolean isLetterGradeSystem(String grade) {
        return grade.equals("A+")
                || grade.equals("A0")
                || grade.equals("B+")
                || grade.equals("B0")
                || grade.equals("C+")
                || grade.equals("C0")
                || grade.equals("D+")
                || grade.equals("D0")
                || grade.equals("F");
    }

    private static boolean isPassFailGradeSystem(String grade) {
        return grade.equals("P");
    }
}