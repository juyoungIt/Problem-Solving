// BOJ - 11739
// Problem Sheet - https://www.acmicpc.net/problem/11739

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Deque<Integer>> problems = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            problems.add(i, new ArrayDeque<>());
            int count = Integer.parseInt(st.nextToken());
            for (int j=0 ; j<count ; j++) {
                problems.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int sum = 0;
        int selectedCount = 0;
        for (int i=0 ; i<k ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (selectedCount == k) break;
                if (problems.get(j).isEmpty()) {
                    sum += 50;
                    selectedCount++;
                } else {
                    int score = problems.get(j).poll();
                    if (sum <= score) {
                        sum += score;
                        selectedCount++;
                    }
                }
            }
        }

        sum = sum + 50 * Math.max(0, k - selectedCount);
        System.out.println(sum);
        br.close();
    }
}
