// BOJ - 1700
// Problem Sheet - https://www.acmicpc.net/problem/1700

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 한번에 사용 가능한 멀티탭 구획의 수
        int k = Integer.parseInt(st.nextToken()); // 전기용품의 총 사용횟수
        int[] useCounts = new int[k+1]; // 각 전자제품의 사용 빈도수를 저장
        LinkedList<Integer> readyQueue = new LinkedList<>(); // 사용을 기다리는 전자제품을 순서대로 저장
        LinkedList<Integer> jobQueue = new LinkedList<>(); // 멀티탭에서 사용 중인 제품들을 유지
        int answer = 0; // 플러그를 뽑은 횟수

        // ready queue 및 각 제품별 사용빈도수 카운트
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<k ; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            readyQueue.add(tmp);
            useCounts[tmp]++;
        }

        // k개의 ready queue가 빈 상태가 될 때까지 다음을 반복함
        while(!readyQueue.isEmpty()) {
            int request = readyQueue.poll(); // 다음 사용요청을 불러옴
            // 이미 멀티탭에서 사용 중인 제품인 경우
            if(jobQueue.contains(request)) {
                useCounts[request]--; // 사용횟수 반영
                continue;
            }
            else {
                // jobQueue의 size가 n 미만인 경우
                if(jobQueue.size() < n) {
                    jobQueue.add(request); // 멀티탭에 플러그를 연결
                    useCounts[request]--; // 사용횟수 반영
                }
                else {
                    // jobQueue에서 우선순위가 가장 낮은 제품 1개를 poll 함
                    jobQueue.remove(findMinPriority(jobQueue, readyQueue, k));
                    answer++; // 플러그를 1회 뽑았으므로 1증가
                    jobQueue.add(request); // 생긴 빈 자리에 플러그를 연결
                    useCounts[request]--; // 사용횟수 반영
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    // 현 호출시점에서 현재 jobQueue에 담겨있는 요소별로 가장 가까운 재호출 거리를 계산함 (없을 경우 k로 처리함)
    public static int findMinPriority(LinkedList<Integer> jobQueue, LinkedList<Integer> readyQueue, int k) {
        int minPriorityIdx = 0; // 가장 낮은 우선순위를 가지는 요소의 인덱스
        int maxDist = 0; // 수집된 거리 중 가장 긴 거리

        for(int i=0 ; i<jobQueue.size() ; i++) {
            int tmp = jobQueue.get(i); // 해당 순서의 job을 유지
            int dist = -1; // 해당 job과 다음 요청 사이의 거리
            for(int j=0 ; j<readyQueue.size() ; j++) {
                if(tmp == readyQueue.get(j)) {
                    dist = j;
                    break;
                }
            }
            if(dist == -1)
                dist = readyQueue.size();
            if(maxDist < dist) {
                maxDist = dist;
                minPriorityIdx = i;
            }
        }
        return minPriorityIdx;
    }
}