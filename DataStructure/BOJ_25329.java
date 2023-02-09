// BOJ - 25329
// Problem Sheet - https://www.acmicpc.net/problem/25329

import java.util.*;
import java.io.*;

public class Main {

    private static final int ONE_HOUR = 60; // 1시간의 분단위
    private static final int BASE_TIME = 100; // 기본시간(분)
    private static final int TIME_UNIT = 50; // 단위시간(분)
    private static final int BASE_CHARGE = 10; // 기본요금(원)
    private static final int UNIT_CHARGE = 3; // 단위요금(원)

    static class Student implements Comparable<Student> {
        private final String name;
        private final int charge;

        public Student(String name, int charge) {
            this.name = name;
            this.charge = charge;
        }

        public String getName() { return this.name; }
        public int getCharge() { return this.charge; }

        @Override
        public int compareTo(Student student) {
            if(this.charge != student.getCharge()) {
                return Integer.compare(this.charge, student.getCharge()) * -1;
            } else {
                return this.name.compareTo(student.getName());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> chargeMapper = new HashMap<>(); // 각 인원별 통화요금
        StringTokenizer st;

        int callLogCount = Integer.parseInt(bf.readLine()); // 통화기록의 수
        for(int i=0 ; i<callLogCount ; i++) {
            st = new StringTokenizer(bf.readLine());
            int minuteTime = covertToMinute(st.nextToken());
            String name = st.nextToken();

            if(!chargeMapper.containsKey(name)) {
                chargeMapper.put(name, minuteTime);
            } else {
                chargeMapper.put(name, chargeMapper.get(name) + minuteTime);
            }
        }

        List<Student> charges = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : chargeMapper.entrySet()) {
            charges.add(new Student(entry.getKey(), calculateCharge(entry.getValue())));
        }
        Collections.sort(charges); // 정해진 기준에 따라 정렬

        for(Student student : charges) {
            System.out.println(student.getName() + " " + student.getCharge());
        }

        bf.close();
        System.exit(0);
    }

    static int covertToMinute(String timeStr) {
        String[] timeTokens = timeStr.split(":");
        int hours = Integer.parseInt(timeTokens[0]);
        int minutes = Integer.parseInt(timeTokens[1]);

        return hours * ONE_HOUR + minutes;
    }

    static int calculateCharge(int totalMinute) {
        if(totalMinute <= BASE_TIME) {
            return BASE_CHARGE;
        }
        return BASE_CHARGE + (int)Math.ceil((double)(totalMinute - BASE_TIME) / TIME_UNIT) * UNIT_CHARGE;
    }
}