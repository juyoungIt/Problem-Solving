// BOJ - 25584
// Problem Sheet - https://www.acmicpc.net/problem/25584

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> workTimes = new HashMap<>(); // 각 사람별 근무시간
        int[] workTime = { 4, 6, 4, 10 }; // 각 타임별 근무시간

        int weeks = Integer.parseInt(bf.readLine()); // 주차 수
        for(int i=0 ; i<weeks ; i++) {
            for (int time : workTime) {
                String[] workers = bf.readLine().split(" ");
                for (String worker : workers) {
                    if (!worker.equals("-")) {
                        if (!workTimes.containsKey(worker)) {
                            workTimes.put(worker, time);
                        } else {
                            workTimes.put(worker, workTimes.get(worker) + time);
                        }
                    }
                }
            }
        }

        List<Integer> countInfo = new ArrayList<>(workTimes.size());
        for(Map.Entry<String, Integer> entry : workTimes.entrySet()) {
            countInfo.add(entry.getValue());
        }
        Collections.sort(countInfo);

        if(countInfo.size() > 0) {
            System.out.println((countInfo.get(countInfo.size()-1) - countInfo.get(0) <= 12) ? "Yes" : "No");
        } else {
            System.out.println("Yes");
        }

        bf.close();
        System.exit(0);
    }
}