// BOJ - 25326
// Problem Sheet - https://www.acmicpc.net/problem/25326

import java.util.*;
import java.io.*;

public class Main {

    static class PreferenceInfo {
        private final String subject;
        private final String fruit;
        private final String color;

        public PreferenceInfo(String subject, String fruit, String color) {
            this.subject = subject;
            this.fruit = fruit;
            this.color = color;
        }

        public String getSubject() { return this.subject; }
        public String getFruit() { return this.fruit; }
        public String getColor() { return this.color; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 학생들의 선호도 정보 수
        int m = Integer.parseInt(st.nextToken()); // 질의의 수
        List<PreferenceInfo> preferenceInfos = new ArrayList<>(n);
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            String subject = st.nextToken();
            String fruit = st.nextToken();
            String color = st.nextToken();
            preferenceInfos.add(new PreferenceInfo(subject, fruit, color));
        }
        for(int i=0 ; i<m ; i++) {
            int matchedCount = 0; // 조건에 매칭되는 정보의 수
            st = new StringTokenizer(bf.readLine());
            String subject = st.nextToken();
            String fruit = st.nextToken();
            String color = st.nextToken();

            for(PreferenceInfo preferenceInfo : preferenceInfos) {
                boolean subjectMatched = subject.equals("-");
                boolean fruitMatched = fruit.equals("-");
                boolean colorMatched = color.equals("-");

                if(!subjectMatched) {
                    if(preferenceInfo.getSubject().equals(subject)) {
                        subjectMatched = true;
                    }
                }
                if(!fruitMatched) {
                    if(preferenceInfo.getFruit().equals(fruit)) {
                        fruitMatched = true;
                    }
                }
                if(!colorMatched) {
                    if(preferenceInfo.getColor().equals(color)) {
                        colorMatched = true;
                    }
                }
                if(subjectMatched && fruitMatched && colorMatched) {
                    matchedCount++;
                }
            }

            System.out.println(matchedCount);
        }

        bf.close();
        System.exit(0);
    }
}