// BOJ - 2754
// Problem Sheet - https://www.acmicpc.net/problem/2754

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> gradeMapper = new HashMap<>();
        List<String> letterGrades = new ArrayList<>(13);
        List<Double> numberGrades = new ArrayList<>(13);
        letterGrades.addAll(List.of("A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F"));
        numberGrades.addAll(List.of(4.3, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0));

        for(int i=0 ; i<letterGrades.size() ; i++) {
            gradeMapper.put(letterGrades.get(i), numberGrades.get(i));
        }

        String letterGrade = bf.readLine();
        System.out.println(gradeMapper.get(letterGrade));

        bf.close();
        System.exit(0);
    }
}