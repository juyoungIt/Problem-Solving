// BOJ - 20551
// Problem Sheet - https://www.acmicpc.net/problem/20551

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배열 A의 원소의 수
        int m = Integer.parseInt(st.nextToken()); // 질문의 개수

        // 배열 A의 원소를 입력받아 오름차순으로 구성함
        List<Integer> sequence = new ArrayList<>(n);
        for(int i=0 ; i<n ; i++) {
            sequence.add(Integer.parseInt(bf.readLine()));
        }
        Collections.sort(sequence); // 오름차순으로 정렬

        // 질문에 대한 각 답변을 출력함
        for(int i=0 ; i<m ; i++) {
            int question = Integer.parseInt(bf.readLine());
            System.out.println(findIndex(sequence, question));
        }

        bf.close();
        System.exit(0);
    }

    // 이분 탐색으로 배열에 들어있는 원소의 인덱스를 찾음
    static int findIndex(List<Integer> arr, int element) {
        int left = 0;
        int right = arr.size() - 1;
        int mid;
        boolean isFound = false;

        while(left <= right) {
            mid = (left + right) / 2;
            if(arr.get(mid) < element) {
                left = mid + 1;
            } else {
                if(arr.get(mid) == element) isFound = true;
                right = mid - 1;
            }
        }
        return (isFound) ? left : -1;
    }
}