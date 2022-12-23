// BOJ - 3018
// Problem Sheet - https://www.acmicpc.net/problem/3018

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // MT에 참가한 사람의 수
        int e = Integer.parseInt(bf.readLine()); // MT 일 수
        int totalMusics = 0; // MT기간 동안 다뤄진 음악의 수
        Map<Integer, Set<Integer>> personMapper = new LinkedHashMap<>();

        // ObjectPool을 구성함
        for(int i=1; i<=n ; i++) {
            personMapper.put(i, new HashSet<>());
        }

        StringTokenizer st;
        for(int i=0 ; i<e ; i++) {
            List<Integer> participants = new ArrayList<>(); // 참가자를 일시저장
            st = new StringTokenizer(bf.readLine());
            int size = Integer.parseInt(st.nextToken()); // 참가자 수
            for(int j=0 ; j<size ; j++) {
                participants.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(participants); // 참가자 번호기준 오름차순 정렬

            if(participants.get(0) == 1) { // 선영이가 참여한 경우
                totalMusics++;
                for(int participant : participants) {
                    personMapper.get(participant).add(i); // 알게된 노래의 id를 넣어줌
                }
            }
            else { // 선영이가 참여하지 않은 경우
                Set<Integer> tmpMusics = new HashSet<>(); // 참여한 사람들이 알고 있는 음악들
                for(int participant : participants) {
                    tmpMusics.addAll(personMapper.get(participant));
                }
                for(int participant : participants) { // 알고 있는 음악을 서로 공유함
                    personMapper.get(participant).addAll(tmpMusics);
                }
            }
        }

        // 종합된 결과를 출력함
        for(Map.Entry<Integer, Set<Integer>> entry : personMapper.entrySet()) {
            if(entry.getValue().size() == totalMusics) {
                System.out.println(entry.getKey());
            }
        }

        bf.close();
        System.exit(0);
    }
}