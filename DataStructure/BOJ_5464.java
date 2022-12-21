// BOJ - 5464
// Problem Sheet - https://www.acmicpc.net/problem/5464

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int totalFee = 0; // 총 주차요금

        int n = Integer.parseInt(st.nextToken()); // 주차 공간의 수
        int m = Integer.parseInt(st.nextToken()); // 차량의 수
        Queue<Integer> waitings = new LinkedList<>(); // 차량 대기열
        List<Integer> parkingStatus = new ArrayList<>();
        for(int i=0 ; i<n ; i++) parkingStatus.add(0);

        List<Integer> parkingFees = new ArrayList<>(n); // 주차 공간의 단위 무게당 요금
        for(int i=0 ; i<n ; i++) {
            parkingFees.add(Integer.parseInt(bf.readLine()));
        }

        List<Integer> weights = new ArrayList<>(m); // 차량의 무게
        for(int i=0 ; i<m ; i++) {
            weights.add(Integer.parseInt(bf.readLine()));
        }

        // 모든 기록에 대한 조회가 끝날 때까지 다음을 반복
        for(int i=0 ; i<m*2 ; i++) {
            int event = Integer.parseInt(bf.readLine());
            if(event > 0) waitings.add(event); // 대기열에 추가
            else {
                int carNum = Math.abs(event);
                int parkingIdx = parkingStatus.indexOf(carNum);
                parkingStatus.set(parkingIdx, 0); // 차량이 나간 것으로 처리
            }
            if(waitings.size() > 0) {
                int carNum = waitings.peek(); // 대기열에 있는 한대의 차량을 가져옴
                int parkingIdx = parkingStatus.indexOf(0); // 주차 가능한 위치를 찾음
                if(parkingIdx > -1) { // 주차 가능한 위치가 있다면
                    totalFee += parkingFees.get(parkingIdx) * weights.get(carNum-1); // 요금계산
                    parkingStatus.set(parkingIdx, carNum); // 주차상태 업데이트
                    waitings.poll(); // 대기열 상태반영
                }
            }
        }

        System.out.println(totalFee);

        bf.close();
        System.exit(0);
    }
}